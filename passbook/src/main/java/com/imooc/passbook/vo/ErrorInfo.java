package com.imooc.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>Global Error Info</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo<T> {

    // General error code
    public static final Integer ERROR = -1;

    // Specific error code
    private Integer code;

    // Error message
    private String message;

    // Save request URL
    private String url;

    // Generic data to return
    private T data;
}
