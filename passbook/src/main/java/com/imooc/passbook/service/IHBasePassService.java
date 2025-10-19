package com.imooc.passbook.service;

import com.imooc.passbook.vo.PassTemplate;

/**
 * <h1>Drop PassTemplate to HBase Service Interface</h1>
 */
public interface IHBasePassService {

    /**
     * <h2>Drop PassTemplate to HBase</h2>
     * @param passTemplate {@link PassTemplate}
     * @return true/false
     * */
    boolean dropPassTemplateToHBase(PassTemplate passTemplate);
}
