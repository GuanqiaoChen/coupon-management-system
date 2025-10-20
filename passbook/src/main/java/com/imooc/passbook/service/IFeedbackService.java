package com.imooc.passbook.service;

import com.imooc.passbook.vo.Feedback;
import com.imooc.passbook.vo.Response;

/**
 * <h1>Feedback Service Interface: Create and Get</h1>
 */
public interface IFeedbackService {

    /**
     * <h2>Create Feedback</h2>
     * @param feedback {@link Feedback}
     * @return {@link Response}
     * */
    Response createFeedback(Feedback feedback);

    /**
     * <h2>Get Feedback</h2>
     * @param userId User id
     * @return {@link Response}
     * */
    Response getFeedback(Long userId);
}
