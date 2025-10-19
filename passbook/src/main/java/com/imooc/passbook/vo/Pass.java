package com.imooc.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <h2>Pass object that user has</h2>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pass {

    // User ID
    private Long userId;

    // Pass in HBase RowKey
    private String rowKey;

    // PassTemplate ID 
    private String templateId;

    // Coupon token. If no token, set to "-1"
    private String token;

    // Assigned date
    private Date assignedDate;

    // Consumption date. If not consumed, set to null
    private Date conDate;
}
