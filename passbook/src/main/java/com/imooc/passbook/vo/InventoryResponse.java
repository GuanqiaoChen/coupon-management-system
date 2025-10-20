package com.imooc.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <h1>Inventory Response</h1>
 * PassTemplate that user is eligible to acquire
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponse {

    /** User id */
    private Long userId;

    /** Passtemplate info */
    private List<PassTemplateInfo> passTemplateInfos;
}
