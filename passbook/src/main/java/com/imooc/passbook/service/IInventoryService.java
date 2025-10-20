package com.imooc.passbook.service;

import com.imooc.passbook.vo.Response;

/**
 * <h1>Inventory Service Interface</h1>
 * PassTemplate that user is eligible to acquire
 * Aka Inventory in merchant's perspective
 */
public interface IInventoryService {

    /**
     * <h2>Get Inventory Info</h2>
     * @param userId User id as each user has different inventory
     * @return {@link Response}
     * */
    Response getInventoryInfo(Long userId) throws Exception;
}
