package com.imooc.passbook.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>Log object</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogObject {

    // Log action
    private String action;

    // User id
    private Long userId;

    // Timestamp
    private Long timestamp;

    // User IP
    private String remoteIp;

    // Log info
    private Object info = null;
}
