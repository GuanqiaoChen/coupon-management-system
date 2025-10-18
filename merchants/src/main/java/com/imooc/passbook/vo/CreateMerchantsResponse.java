package com.imooc.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>Create merchants response</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsResponse {

    /** Merchant ID
     * Fail return -1
     * Don't want to provide messgae to client
    */
    private Integer id;
}
