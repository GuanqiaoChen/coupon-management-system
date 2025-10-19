package com.imooc.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>General Response in Controller</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    /** Error code.Ok return 0 */
    private Integer errorCode = 0;

    /** Error Message. Ok return empty string */
    private String errorMsg = "";

    /** response object */
    private Object data;

    /**
     * <h2>Resonse constructor only used in Ok</h2>
     * @param data response object
     */
    public Response(Object data) {
        this.data = data;
    }

    /**
     * <h2>Empty success response</h2>
     * When no data to return
     */
    public static Response success() {
        return new Response();
    }

    /**
     * <h2>Failure response</h2>
     * @param errorMsg error message
     * @return {@link Response}
     */
    public static Response failure(String errorMsg) {
        return new Response(-1, errorMsg, null);
    }
}
