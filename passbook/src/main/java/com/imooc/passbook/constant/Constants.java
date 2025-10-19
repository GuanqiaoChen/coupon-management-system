package com.imooc.passbook.constant;

/**
 * <h1>General constants</h1>
 */
public class Constants {

    // Merchants coupon Kafka Topic 
    public static final String TEMPLATE_TOPIC = "merchants-template";

    // Directory to save coupon token
    public static final String TOKEN_DIR = "/tmp/token/";

    // Used token suffix 
    public static final String USED_TOKEN_SUFFIX = "_";

    /*
     * Redis key for storing the number of users
     * used to generate user id
     */
    public static final String USE_COUNT_REDIS_KEY = "imooc-user-count";

    /*
     * <h2>User HBase Table</h2>
    */
    public class UserTable {

        // User HBase table 
        public static final String TABLE_NAME = "pb:user";

        // Basic info column family
        public static final String FAMILY_B = "b";

        // User name
        public static final String NAME = "name";

        // User age
        public static final String AGE = "age";

        // User sex
        public static final String SEX = "sex";

        // Other info column family
        public static final String FAMILY_O = "o";

        // User phone
        public static final String PHONE = "phone";

        // User address
        public static final String ADDRESS = "address";
    }

    /**
     * <h2>PassTemplate HBase Table</h2>
     * */
    public class PassTemplateTable {

        // PassTemplate HBase table 
        public static final String TABLE_NAME = "pb:passtemplate";

        // Basic info column family
        public static final String FAMILY_B = "b";

        // Merchant id
        public static final String ID = "id";

        // Coupon title
        public static final String TITLE = "title";

        // Coupon summary
        public static final String SUMMARY = "summary";

        // Coupon description
        public static final String DESC = "desc";

        // Coupon whether has token
        public static final String HAS_TOKEN = "has_token";

        // Coupon background color
        public static final String BACKGROUND = "background";

        // Constraint info column family
        public static final String FAMILY_C = "c";

        // Coupon limit for single merchant 
        public static final String LIMIT = "limit";

        // Coupon start time
        public static final String START = "start";

        // Coupon end time
        public static final String END = "end";
    }

    /**
     * <h2>Pass HBase Table</h2>
     * */
    public class PassTable {

        // Pass HBase table
        public static final String TABLE_NAME = "pb:pass";

        // Information column family
        public static final String FAMILY_I = "i";

        // User id
        public static final String USER_ID = "user_id";

        // PassTemplate RowKey
        public static final String TEMPLATE_ID = "template_id";

        // Coupon token, may be null
        public static final String TOKEN = "token";

        // Assigned date
        public static final String ASSIGNED_DATE = "assigned_date";

        // Consumption date
        public static final String CON_DATE = "con_date";
    }

    /**
     * <h2>Feedback Hbase Table</h2>
     * */
    public class Feedback {

        // Feedback HBase table
        public static final String TABLE_NAME = "pb:feedback";

        // Information column family
        public static final String FAMILY_I = "i";

        // User id
        public static final String USER_ID = "user_id";

        // Feedback type
        public static final String TYPE = "type";

        /* PassTemplate RowKey
         * If it isfeedback type is APP, this field is -1
        */
        public static final String TEMPLATE_ID = "template_id";

        // Feedback comment
        public static final String COMMENT = "comment";
    }
}
