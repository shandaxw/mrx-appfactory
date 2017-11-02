package com.mrx.appfactory.common.core;

/**
 * 
 * @author xuwen
 *
 */
public enum APIResults {

    ELSE(-5, "其他错误"),
    DATABASE_EXCEPTION(-4, "数据库错误"),
    PARAM_INVALID(-1, "参数错误"),
    SUCCESS(0, "请求成功"),
    FAILED(1, "请求失败");

    private final int code;
    private final String message;

    private APIResults(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
