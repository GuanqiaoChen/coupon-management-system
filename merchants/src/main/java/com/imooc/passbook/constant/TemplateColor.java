package com.imooc.passbook.constant;

/**
 * Background colors for the coupon template
 */
public enum TemplateColor {

    RED(1, "red"),
    GREEN(2, "green"),
    BLUE(3, "blue");

    // Color code 
    private Integer code;

    // Color description 
    private String color;

    TemplateColor(Integer code, String color) {
        this.code = code;
        this.color = color;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getColor() {
        return this.color;
    }
}
