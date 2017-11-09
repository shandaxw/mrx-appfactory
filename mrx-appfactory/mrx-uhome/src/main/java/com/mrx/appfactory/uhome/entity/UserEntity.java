package com.mrx.appfactory.uhome.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

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
     * 帐号
     */
    @JsonInclude(Include.NON_NULL)
    @NotBlank
    private String account;
    /**
     * 密码
     */
    @JsonInclude(Include.NON_NULL)
    @NotBlank
    private String password;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年7月20日 xuwen create
 */
