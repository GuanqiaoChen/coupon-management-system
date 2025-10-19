package com.imooc.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>General Response in Controller</h1>
 * Should be improved in the future
 * Add extended response types
 * Add generic support
 * Add error handling 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    /* Error code
     * Ok return 0 
    */
    private Integer errorCode = 0;

    /* Error Message. 
     * Ok return empty string 
    */
    private String errorMsg = "";

    // response object 
    private Object data;

    /**
     * <h2>Constructor</h2>
     * @param data response object
     * */
    public Response(Object data) {
        this.data = data;
    }
}
