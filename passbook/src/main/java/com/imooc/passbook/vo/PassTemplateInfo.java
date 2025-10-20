package com.imooc.passbook.vo;

import com.imooc.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <h1>PassTemplate Info</h1>
 * PassTemplate and corresponding merchant information that user has not acquired yet
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplateInfo {

    /** Passtemplate */
    private PassTemplate passTemplate;

    /** Corresponding merchant */
    private Merchants merchants;
}
