package com.mrx.appfactory.common.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mrx.appfactory.common.util.StringUtil;

/**
 * 
 * @author xuwen
 *
 */
public class APIResult {
    private int code;
    private String message;
    @JsonInclude(Include.NON_NULL)
    private Object data;

    public APIResult(APIResults apiResults) {
        this.code = apiResults.getCode();
        this.message = apiResults.getMessage();
    }

    public APIResult(APIResults apiResults, String message) {
        this.code = apiResults.getCode();
        this.message = StringUtil.isNotBlank(message) ? message : apiResults.getMessage();
    }

    public APIResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public APIResult() {
        this(APIResults.SUCCESS);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static APIResult getResult(APIResults apiResult, Object data) {
        APIResult result = new APIResult(apiResult);
        result.setData(data);
        return result;
    }

    public static APIResult getResult(APIResults apiResult) {
        return new APIResult(apiResult);
    }
}
