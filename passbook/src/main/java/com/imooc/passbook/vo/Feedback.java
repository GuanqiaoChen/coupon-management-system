package com.imooc.passbook.vo;

import com.google.common.base.Enums;
import com.imooc.passbook.constant.FeedbackType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>User feedback object</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    // User id
    private Long userId;

    // Feedback type
    private String type;

    // PassTemplate id. If app feedback, set to "-1"
    private String templateId;

    // Feedback comment
    private String comment;

    /* Check if feedback type is valid*/
    public boolean validate() {
        // Get feedback type enum. If not exist, return null
        FeedbackType feedbackType = Enums.getIfPresent(
                FeedbackType.class, this.type.toUpperCase()
        ).orNull();
        // Type and comment should not be null
        return !(null == feedbackType || null == comment);
    }
}
