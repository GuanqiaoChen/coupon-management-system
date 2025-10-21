package com.imooc.passbook.service;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <h1>User Service Test</h1>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testCreateUser() throws Exception {

        User user = new User();
        user.setBaseInfo(
                new User.BaseInfo("imooc", 10, "m")
        );
        user.setOtherInfo(
                new User.OtherInfo("123456", "Chaoyang District, Beijing")
        );

        // {"data":{"baseInfo":{"age":10,"name":"imooc","sex":"m"},
        // "id":149276,
        // "otherInfo":{"address":"Chaoyang District, Beijing","phone":"123456"}},
        // "errorCode":0,"errorMsg":""}
        System.out.println(JSON.toJSONString(userService.createUser(user)));
    }
}
