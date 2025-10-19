package com.imooc.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>User object</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    // User id. Primary Key
    private Long id;

    /* First column family in HBase User table
     * User basic information
    */
    private BaseInfo baseInfo;

    /* Second column family in HBase User table
     * User other information
    */
    private OtherInfo otherInfo;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BaseInfo {

        private String name;
        private Integer age;
        private String sex;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OtherInfo {

        private String phone;
        private String address;
    }
}
