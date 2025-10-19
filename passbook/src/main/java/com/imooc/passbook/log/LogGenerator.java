package com.imooc.passbook.log;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>Log generator</h1>
 */
@Slf4j
public class LogGenerator {

    /**
     * <h2>Generate log</h2>
     * @param request {@link HttpServletRequest}. Want to get user IP from it
     * @param userId User id
     * @param action User action
     * @param info Log info. Can be null
     * */
    public static void genLog(HttpServletRequest request, Long userId, String action, Object info) {

        log.info(
                JSON.toJSONString(
                        new LogObject(action, userId, System.currentTimeMillis(), request.getRemoteAddr(), info)
                )
        );
    }
}
