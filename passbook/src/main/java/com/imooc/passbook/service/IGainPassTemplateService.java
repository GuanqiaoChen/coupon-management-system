package com.imooc.passbook.service;

import com.imooc.passbook.vo.GainPassTemplateRequest;
import com.imooc.passbook.vo.Response;

/**
 * <h1>Gain PassTemplate Service Interface</h1>
 */
public interface IGainPassTemplateService {

    /**
     * <h2>Gain PassTemplate</h2>
     * @param request {@link GainPassTemplateRequest}
     * @return {@link Response}
     * */
    Response gainPassTemplate(GainPassTemplateRequest request) throws Exception;
}
