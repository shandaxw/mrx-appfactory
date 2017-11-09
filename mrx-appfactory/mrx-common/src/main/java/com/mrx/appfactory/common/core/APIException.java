package com.mrx.appfactory.common.core;

/**
 * 
 * @author xuwen
 *
 */
public class APIException extends Exception {

    private static final long serialVersionUID = 1L;

    private int code;

    private String message;

    public APIException(APIResults exception) {
        this.code = exception.getCode();
        this.message = exception.getMessage();
    }

    public APIException(APIResults exception, String message) {
        this.code = exception.getCode();
        this.message = message;
    }

    public APIException(int code, String message) {
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
