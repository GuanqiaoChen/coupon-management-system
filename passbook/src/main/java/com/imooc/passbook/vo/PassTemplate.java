package com.imooc.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <h1>PassTemplate object</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplate {

    // Merchant ID. Primary Key
    private Integer id;

    // Coupon title
    private String title;

    // Coupon summary
    private String summary;

    // Coupon description
    private String desc;

    // Max number of coupons
    private Long limit;

    // If it is token coupon. For authenticate
    private Boolean hasToken;

    // Coupon background color
    private Integer background;

    // Coupon start time
    private Date start;

    // Coupon expired time
    private Date end;
}
