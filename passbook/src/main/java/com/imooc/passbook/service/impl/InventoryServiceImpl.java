package com.imooc.passbook.service.impl;

import com.imooc.passbook.constant.Constants;
import com.imooc.passbook.dao.MerchantsDao;
import com.imooc.passbook.entity.Merchants;
import com.imooc.passbook.mapper.PassTemplateRowMapper;
import com.imooc.passbook.service.IInventoryService;
import com.imooc.passbook.service.IUserPassService;
import com.imooc.passbook.utils.RowKeyGenUtil;
import com.imooc.passbook.vo.InventoryResponse;
import com.imooc.passbook.vo.PassInfo;
import com.imooc.passbook.vo.PassTemplate;
import com.imooc.passbook.vo.PassTemplateInfo;
import com.imooc.passbook.vo.Response;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.LongComparator;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <h1>Inventory Service Implement</h1>
 * PassTemplate that user is eligible to acquire
 * Aka Inventory in merchant's perspective
 * Which means the available PassTemplate for user to get
 * Since each PassTemplateInfo contains PassTemplate and Merchants info
 * we need to inject Merchants Dao first
 */
@Slf4j
@Service
public class InventoryServiceImpl implements IInventoryService {

    /** Hbase client */
    private final HbaseTemplate hbaseTemplate;

    /** Merchants Dao Interface */
    private final MerchantsDao merchantsDao;

    /*
     * UserPass Service Interface 
     * To get user's acquired PassTemplate list
     */
    private final IUserPassService userPassService;

    @Autowired
    public InventoryServiceImpl(HbaseTemplate hbaseTemplate,
                                MerchantsDao merchantsDao,
                                IUserPassService userPassService) {
        this.hbaseTemplate = hbaseTemplate;
        this.merchantsDao = merchantsDao;
        this.userPassService = userPassService;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Response getInventoryInfo(Long userId) throws Exception {

        // Get all acquired PassTemplate by userId
        Response allUserPass = userPassService.getUserAllPassInfo(userId);
        List<PassInfo> passInfos = (List<PassInfo>) allUserPass.getData();

        // Build excludeIds list that user has already acquired
        List<PassTemplate> excludeObject = passInfos.stream().map(PassInfo::getPassTemplate)
                .collect(Collectors.toList());
        List<String> excludeIds = new ArrayList<>();

        excludeObject.forEach(e -> excludeIds.add(
                RowKeyGenUtil.genPassTemplateRowKey(e)));

        /* 
         * Get available PassTemplate that user can acquire
         * We have put all validation logic in getAvailablePassTemplate method
         * Then use buildPassTemplateInfo to build PassTemplateInfo list
         */ 
        return new Response(new InventoryResponse(userId,
                buildPassTemplateInfo(getAvailablePassTemplate(excludeIds))));
    }

    /**
     * <h2>Get Available PassTemplate</h2>
     * @param excludeIds excludeIds: The passTemplate id list that user has already acquired
     * @return {@link PassTemplate}
     * */
    private List<PassTemplate> getAvailablePassTemplate(List<String> excludeIds) {

        // Only need one condition to satisfy
        FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ONE);

        // limit > 0 || limit = -1
        filterList.addFilter(
                new SingleColumnValueFilter(
                        Bytes.toBytes(Constants.PassTemplateTable.FAMILY_C),
                        Bytes.toBytes(Constants.PassTemplateTable.LIMIT),
                        CompareFilter.CompareOp.GREATER,
                        new LongComparator(0L)
                )
        );
        filterList.addFilter(
                new SingleColumnValueFilter(
                        Bytes.toBytes(Constants.PassTemplateTable.FAMILY_C),
                        Bytes.toBytes(Constants.PassTemplateTable.LIMIT),
                        CompareFilter.CompareOp.EQUAL,
                        Bytes.toBytes("-1")
                )
        );

        Scan scan = new Scan();
        scan.setFilter(filterList);

        // Get all PassTemplate that satisfy the filter condition
        List<PassTemplate> validTemplates = hbaseTemplate.find(
                Constants.PassTemplateTable.TABLE_NAME, scan, new PassTemplateRowMapper());


        List<PassTemplate> availablePassTemplates = new ArrayList<>();

        // Filter the expired PassTemplate
        Date cur = new Date();

        /** Iterate through validTemplates, exclude those in excludeIds, and check date validity */
        for (PassTemplate validTemplate : validTemplates) {

            // Further exclude the PassTemplate that user has already acquired
            if (excludeIds.contains(RowKeyGenUtil.genPassTemplateRowKey(validTemplate))) {
                continue;
            }

            // Check if the PassTemplate is within the valid date range
            if (cur.getTime() >= validTemplate.getStart().getTime()
                    && cur.getTime() <= validTemplate.getEnd().getTime()) {
                availablePassTemplates.add(validTemplate);
            }
        }

        return availablePassTemplates;
    }

    /**
     * <h2>Build PassTemplateInfo</h2>
     * @param passTemplates {@link PassTemplate}
     * @return {@link PassTemplateInfo}
     * Since each PassTemplateInfo contains PassTemplate and Merchants info
     * we need to build Merchants map first
     * */
    private
    List<PassTemplateInfo> buildPassTemplateInfo(List<PassTemplate> passTemplates) {

        /** Build Merchants Map */
        Map<Integer, Merchants> merchantsMap = new HashMap<>();

        // Get all merchants ids
        List<Integer> merchantsIds = passTemplates.stream().map(
                PassTemplate::getId
        ).collect(Collectors.toList());

        // Get merchants info and build the map
        List<Merchants> merchants = merchantsDao.findByIdIn(merchantsIds);
        merchants.forEach(m -> merchantsMap.put(m.getId(), m));

        /** Build PassTemplateInfo */
        List<PassTemplateInfo> result = new ArrayList<>(passTemplates.size());

        for (PassTemplate passTemplate : passTemplates) {

            // Get merchants info from the map
            Merchants mc = merchantsMap.getOrDefault(passTemplate.getId(),
                    null);
            if (null == mc) {
                log.error("Merchants Error: {}", passTemplate.getId());
                continue;
            }

            // Build PassTemplateInfo with PassTemplate and Merchants info
            result.add(new PassTemplateInfo(passTemplate, mc));
        }

        return result;
    }
}
