package com.imooc.passbook.security;

/**
 * <h1>Use ThreadLoad to store token carried by a seperate thread</h1>
 */
public class AccessContext {

    private static final ThreadLocal<String> token = new ThreadLocal<String>();

    public static String getToken() {
        return token.get();
    }

    public static void setToken(String tokenStr) {
        token.set(tokenStr);
    }

    public static void clearAccessKey() {
        token.remove();
    }
}
