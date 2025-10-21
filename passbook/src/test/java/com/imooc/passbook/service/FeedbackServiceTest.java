package com.imooc.passbook.service;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.constant.FeedbackType;
import com.imooc.passbook.vo.Feedback;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <h1>User Feedback Service Test</h1>
 * Created by Qinyi.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedbackServiceTest extends AbstractServiceTest {

    @Autowired
    private IFeedbackService feedbackService;

    @Test
    public void testCreateFeedback() {

        Feedback appFeedback = new Feedback();
        appFeedback.setUserId(userId);
        appFeedback.setType(FeedbackType.APP.getCode());
        appFeedback.setTemplateId("-1");
        appFeedback.setComment("Learning distributed coupon management application on MOOC!");

        System.out.println(JSON.toJSONString(
                feedbackService.createFeedback(appFeedback))
        );

        Feedback passFeedback = new Feedback();
        passFeedback.setUserId(userId);
        passFeedback.setType(FeedbackType.PASS.getCode());
        passFeedback.setTemplateId("3617cf73e7a1099097242115042cb7b0");
        passFeedback.setComment("Coupon comment");

        System.out.println(JSON.toJSONString(
                feedbackService.createFeedback(passFeedback)
        ));

        // {"errorCode":0,"errorMsg":""}
        // {"errorCode":0,"errorMsg":""}
    }

//    {
//        "data": [
//        {
//            "comment": "Coupon comment",
//                "templateId": "3617cf73e7a1099097242115042cb7b0",
//                "type": "pass",
//                "userId": 149276
//        },
//        {
//            "comment": "Learning distributed coupon management application on MOOC!",
//                "templateId": "-1",
//                "type": "app",
//                "userId": 149276
//        }
//  ],
//        "errorCode": 0,
//        "errorMsg": ""
//    }

    @Test
    public void testGetFeedback() {

        System.out.println(JSON.toJSONString(
                feedbackService.getFeedback(userId))
        );
    }
}
