package com.imooc.passbook.vo;

import com.imooc.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>Pass Info</h1>
 * Pass is the coupon that user has acquired
 * PassTemplate is the template of the coupon
 * Merchants is the merchant who issues the coupon
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassInfo {

    /** Coupon */
    private Pass pass;

    /** Coupon template */
    private PassTemplate passTemplate;

    /** Corresponding merchant */
    private Merchants merchants;
}
