package com.imooc.passbook.constant;

/**
 * <h1>Feedback type</h1>
 */
public enum FeedbackType {

    PASS("pass", "For coupon feedback"),
    APP("app", "For app feedback");

    /** Feedback code */
    private String code;

    /** Feedback desciption */
    private String desc;

    FeedbackType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
