package com.imooc.passbook.service;

import com.imooc.passbook.vo.CreateMerchantsRequest;
import com.imooc.passbook.vo.PassTemplate;
import com.imooc.passbook.vo.Response;

/**
 * <h1>Merchant service interface</h1>
 */
public interface IMerchantsServ {

    /**
     * <h2>Create merchant sevice</h2>
     * @param request {@link CreateMerchantsRequest} Create merchant request
     * @return {@link Response}
     * */
    Response createMerchants(CreateMerchantsRequest request);

    /**
     * <h2>Build merchant info based on ID</h2>
     * @param id Merchant ID
     * @return {@link Response}
     * */
    Response buildMerchantsInfoById(Integer id);

    /**
     * <h2>Coupon to pass</h2>
     * @param template {@link PassTemplate} Coupon info
     * @return {@link Response}
     * */
    Response dropPassTemplate(PassTemplate template);
}
