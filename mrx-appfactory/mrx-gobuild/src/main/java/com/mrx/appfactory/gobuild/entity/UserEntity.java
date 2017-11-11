package com.mrx.appfactory.gobuild.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @Type UserEntity.java
 * @Desc 
 * @author xuwen
 * @date 2017年7月20日 下午3:18:50
 * @version 
 */
public class UserEntity implements Serializable {

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
     * 姓名
     */
    @JsonInclude(Include.NON_NULL)
    private String name;
    /**
     * 性别
     */
    @JsonInclude(Include.NON_NULL)
    private int sex;
    /**
     * 电话
     */
    @JsonInclude(Include.NON_NULL)
    private String phone;
    /**
     * qq
     */
    @JsonInclude(Include.NON_NULL)
    private String qq;
    /**
     * 头像
     */
    @JsonInclude(Include.NON_NULL)
    private String userHead;
    /**
     * 座右铭
     */
    @JsonInclude(Include.NON_NULL)
    private String userMotto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getUserMotto() {
        return userMotto;
    }

    public void setUserMotto(String userMotto) {
        this.userMotto = userMotto;
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
