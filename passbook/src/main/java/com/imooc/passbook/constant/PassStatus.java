package com.imooc.passbook.constant;

/**
 * <h1>Coupon status</h1>
 */
public enum PassStatus {

    UNUSED(1, "unused"),
    USED(2, "used"),
    ALL(3, "all");

    // Status code 
    private Integer code;

    // Status description 
    private String desc;

    PassStatus(Integer code, String desc) {
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
