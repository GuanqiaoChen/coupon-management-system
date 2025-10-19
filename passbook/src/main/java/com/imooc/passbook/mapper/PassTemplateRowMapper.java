package com.imooc.passbook.mapper;

import com.imooc.passbook.constant.Constants;
import com.imooc.passbook.vo.PassTemplate;
import com.spring4all.spring.boot.starter.hbase.api.RowMapper;
import org.apache.commons.lang.time.DateUtils;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;


/**
 * <h1>ORM: HBase PassTemplate Row To PassTemplate Object</h1>
 * HBase starter RowMapper implementation for PassTemplate
 */
public class PassTemplateRowMapper implements RowMapper<PassTemplate> {

    // Column family B
    private static byte[] FAMILY_B = Constants.PassTemplateTable.FAMILY_B.getBytes();
    private static byte[] ID = Constants.PassTemplateTable.ID.getBytes();
    private static byte[] TITLE = Constants.PassTemplateTable.TITLE.getBytes();
    private static byte[] SUMMARY = Constants.PassTemplateTable.SUMMARY.getBytes();
    private static byte[] DESC = Constants.PassTemplateTable.DESC.getBytes();
    private static byte[] HAS_TOKEN = Constants.PassTemplateTable.HAS_TOKEN.getBytes();
    private static byte[] BACKGROUND = Constants.PassTemplateTable.BACKGROUND.getBytes();

    // Column family C
    private static byte[] FAMILY_C = Constants.PassTemplateTable.FAMILY_C.getBytes();
    private static byte[] LIMIT = Constants.PassTemplateTable.LIMIT.getBytes();
    private static byte[] START = Constants.PassTemplateTable.START.getBytes();
    private static byte[] END = Constants.PassTemplateTable.END.getBytes();

    // Map HBase Result to PassTemplate Object
    @Override
    public PassTemplate mapRow(Result result, int rowNum) throws Exception {

        PassTemplate passTemplate = new PassTemplate();

        // Base Info
        passTemplate.setId(Bytes.toInt(result.getValue(FAMILY_B, ID)));
        passTemplate.setTitle(Bytes.toString(result.getValue(FAMILY_B, TITLE)));
        passTemplate.setSummary(Bytes.toString(result.getValue(FAMILY_B, SUMMARY)));
        passTemplate.setDesc(Bytes.toString(result.getValue(FAMILY_B, DESC)));
        passTemplate.setHasToken(Bytes.toBoolean(result.getValue(FAMILY_B, HAS_TOKEN)));
        passTemplate.setBackground(Bytes.toInt(result.getValue(FAMILY_B, BACKGROUND)));

        // Constraint Info
        String[] patterns = new String[] {"yyyy-MM-dd"};

        passTemplate.setLimit(Bytes.toLong(result.getValue(FAMILY_C, LIMIT)));
        passTemplate.setStart(DateUtils.parseDate(Bytes.toString(result.getValue(FAMILY_C, START)), patterns));
        passTemplate.setEnd(DateUtils.parseDate(Bytes.toString(result.getValue(FAMILY_C, END)), patterns));

        return passTemplate;
    }
}
