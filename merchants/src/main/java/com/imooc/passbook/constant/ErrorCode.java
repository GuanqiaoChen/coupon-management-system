package com.imooc.passbook.constant;

/**
 * <h2>Definition for error code</h2>
 */
public enum ErrorCode {

    SUCCESS(0, ""),
    DUPLICATE_NAME(1, "merchant name already exists"),
    EMPTY_LOGO(2, "merchant logo is empty"),
    EMPTY_BUSINESS_LICENSE(3, "business license is empty"),
    ERROR_PHONE(4, "contact phone is error"),
    EMPTY_ADDRESS(5, "merchant address is empty"),
    MERCHANTS_NOT_EXIST(6, "merchant does not exist"),;

    // Error code 
    private Integer code;

    // Error description 
    private String desc;

    ErrorCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
