package com.mrx.appfactory.cfgtool.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @Type ConfigEntity.java
 * @Desc 
 * @author xuwen
 * @date 2017年7月20日 下午3:18:50
 * @version 
 */
public class ConfigEntity implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @JsonInclude(Include.NON_NULL)
    private Long id;
    /**
     * 页面名称
     */
    @JsonInclude(Include.NON_NULL)
    private String apiName;
    /**
     * 页面编号
     */
    @JsonInclude(Include.NON_NULL)
    private String apiNo;
    /**
     * Json数据
     */
    @JsonInclude(Include.NON_NULL)
    private String jsonData;
    /**
     * json模型
     */
    @JsonInclude(Include.NON_NULL)
    private String jsonString;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiNo() {
        return apiNo;
    }

    public void setApiNo(String apiNo) {
        this.apiNo = apiNo;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

    public String getJsonString() {
        return jsonString;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年7月20日 xuwen create
 */
