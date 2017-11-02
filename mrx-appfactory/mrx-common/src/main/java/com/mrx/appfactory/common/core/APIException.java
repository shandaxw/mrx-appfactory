package com.mrx.appfactory.common.core;

/**
 * 
 * @author xuwen
 *
 */
public class APIException extends Exception {

    private static final long serialVersionUID = 1L;

    private APIResults exception;

    private String message;

    public APIException(APIResults exception) {
        super(exception.getMessage());
        this.exception = exception;
    }

    public APIException(APIResults exception, String message) {
        super(message);
        this.exception = exception;
    }

    public APIResults getException() {
        return exception;
    }

    public String getMessage() {
        if (message != null) {
            return message;
        } else {
            return exception.getMessage();
        }
    }

}
