package com.imooc.passbook.service;

import com.imooc.passbook.vo.Response;
import com.imooc.passbook.vo.User;

/**
 * <h1>User Service Interface: Create</h1>
 */

public interface IUserService {

    /**
     * <h2>Create User</h2>
     * @param user {@link User}
     * @return {@link Response}
     * @throws Exception exception
     */
    Response createUser(User user) throws Exception;
}
