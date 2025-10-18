package com.imooc.passbook.constant;

/**
 * <h1>definition for general constants</h1>
 */
public class Constants {

    /** Kafka Topic for merchants to pass coupon*/
    public static final String TEMPLATE_TOPIC = "merchants-template";

    /** token string (key) to authenticate merchants
     * assume we use a fixed token for merchants' authentication
    */
    public static final String TOKEN_STRING = "token";

    /** token info (value) to authenticate merchants */
    public static final String TOKEN = "imooc-passbook-merchants";
}
