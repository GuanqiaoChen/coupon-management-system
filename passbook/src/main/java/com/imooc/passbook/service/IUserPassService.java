package com.imooc.passbook.service;

import com.imooc.passbook.vo.Pass;
import com.imooc.passbook.vo.Response;

/**
 * <h1>Get User Pass Service Interface</h1>
 * User's personal Pass info
 */
public interface IUserPassService {

    /**
     * <h2>Gain pass that user has not used</h2>
     * @param userId User id
     * @return {@link Response}
     * */
    Response getUserPassInfo(Long userId) throws Exception;

    /**
     * <h2>Gain pass that user has used</h2>
     * @param userId User id
     * @return {@link Response}
     * */
    Response getUserUsedPassInfo(Long userId) throws Exception;

    /**
     * <h2>Gain all pass of user (including used and unused)</h2>
     * @param userId User id
     * @return {@link Response}
     * */
    Response getUserAllPassInfo(Long userId) throws Exception;

    /**
     * <h2>User use pass</h2>
     * @param pass {@link Pass}
     * @return {@link Response}
     * */
    Response userUsePass(Pass pass);
}
