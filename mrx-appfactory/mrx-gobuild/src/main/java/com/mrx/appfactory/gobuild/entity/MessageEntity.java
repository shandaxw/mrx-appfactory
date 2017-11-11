package com.mrx.appfactory.gobuild.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @Type MessageEntity.java
 * @Desc 
 * @author xuwen
 * @date 2017年7月20日 下午3:18:50
 * @version 
 */
public class MessageEntity implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @JsonInclude(Include.NON_NULL)
    private String id;
    /**
     * 用户ID
     */
    @JsonInclude(Include.NON_NULL)
    @NotBlank
    private String userId;
    /**
     * 名字
     */
    @JsonInclude(Include.NON_NULL)
    @NotBlank
    private String messager;
    /**
     * 邮箱
     */
    @JsonInclude(Include.NON_NULL)
    @NotBlank
    private String email;
    /**
     * 信息
     */
    @JsonInclude(Include.NON_NULL)
    @NotBlank
    private String message;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessager() {
        return messager;
    }

    public void setMessager(String messager) {
        this.messager = messager;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
