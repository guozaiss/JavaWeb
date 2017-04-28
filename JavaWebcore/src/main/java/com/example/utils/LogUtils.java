package com.example.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Guo on 2017/4/28.
 */
public class LogUtils {
    public static void log(String msg) {
        Thread thread = Thread.currentThread();
        StackTraceElement[] stackTrace = thread.getStackTrace();
        try {
            StackTraceElement stackTraceElement = stackTrace[2];
            Logger logger = LoggerFactory.getLogger(Class.forName(stackTraceElement.getClassName()));
            logger.info("methodName: " + stackTraceElement.getMethodName() + "  "
                    + stackTraceElement.getLineNumber() + "行:\n\r           " + msg);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}