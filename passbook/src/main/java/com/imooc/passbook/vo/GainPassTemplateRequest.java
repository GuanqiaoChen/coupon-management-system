package com.imooc.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>Gain PassTemplate Request</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GainPassTemplateRequest {

    /** User id */
    private Long userId;

    /** PassTemplate */
    private PassTemplate passTemplate;
}
