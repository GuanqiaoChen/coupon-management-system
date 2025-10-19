package com.imooc.passbook.log;

/**
 * <h1>Log constants</h1>
 */
public class LogConstants {

    /**
     * <h2>User actions</h2>
     * */
    public class ActionName {

        // User gets coupon info
        public static final String USER_PASS_INFO = "UserPassInfo";

        // User gets used coupon info
        public static final String USER_USED_PASS_INFO = "UserUsedPassInfo";

        // User uses coupon
        public static final String USER_USE_PASS = "UserUsePass";

        // User gets inventory info
        public static final String INVENTORY_INFO = "InventoryInfo";

        // User gets coupon template info
        public static final String GAIN_PASS_TEMPLATE = "GainPassTemplate";

        // User creates feedback
        public static final String CREATE_FEEDBACK = "CreateFeedback";

        // User gets feedback
        public static final String GET_FEEDBACK = "GetFeedback";

        // Create user
        public static final String CREATE_USER = "CreateUser";
    }
}
