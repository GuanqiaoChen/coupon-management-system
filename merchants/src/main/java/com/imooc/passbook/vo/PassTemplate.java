package com.imooc.passbook.vo;

import com.imooc.passbook.constant.ErrorCode;
import com.imooc.passbook.dao.MerchantsDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <h1>Define mandatory coupon info</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplate {

    // Merchant ID 
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
    private Boolean hasToken; // token stored in Redis Set. Get from there

    // Coupon background color 
    private Integer background;

    // Coupon start date 
    private Date start;

    // Coupon expired date 
    private Date end;

    /**
     * <h2>Validate coupon</h2>
     * @param merchantsDao {@link MerchantsDao}
     * @return {@link ErrorCode}
     * */
    public ErrorCode validate(MerchantsDao merchantsDao) {

        if (null == merchantsDao.findById(id)) {
            return ErrorCode.MERCHANTS_NOT_EXIST;
        }

        return ErrorCode.SUCCESS;
    }
}
