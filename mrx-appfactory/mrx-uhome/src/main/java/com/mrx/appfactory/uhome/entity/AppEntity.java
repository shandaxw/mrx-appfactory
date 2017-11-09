package com.mrx.appfactory.uhome.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @Type AppEntity.java
 * @Desc 
 * @author xuwen
 * @date 2017年7月20日 下午3:18:50
 * @version 
 */
public class AppEntity implements Serializable {

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
     * 注册ID
     */
    @JsonInclude(Include.NON_NULL)
    private String appId;
    /**
     * 服务器时间规则
     */
    @JsonInclude(Include.NON_NULL)
    private String timeRule;
    /**
     * 应用名称
     */
    @JsonInclude(Include.NON_NULL)
    private String appName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTimeRule() {
        return timeRule;
    }

    public void setTimeRule(String timeRule) {
        this.timeRule = timeRule;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
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
