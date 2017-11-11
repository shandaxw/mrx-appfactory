package com.mrx.appfactory.gobuild.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mrx.appfactory.common.core.DateJsonSerializer;

/**
 * @Type PostEntity.java
 * @Desc 
 * @author xuwen
 * @date 2017年7月20日 下午3:18:50
 * @version 
 */
public class PostEntity implements Serializable {

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
     * 用户ID
     */
    @JsonInclude(Include.NON_NULL)
    private String userId;
    /**
     * 帖子图片
     */
    @JsonInclude(Include.NON_NULL)
    private String postImg;
    /**
     * 帖子名称
     */
    @JsonInclude(Include.NON_NULL)
    private String postName;
    /**
     * 帖子内容
     */
    @JsonInclude(Include.NON_NULL)
    private String postContent;
    /**
     * 更新时间
     */
    @JsonInclude(Include.NON_NULL)
    private Timestamp updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    @JsonSerialize(using = DateJsonSerializer.class)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getPostImg() {
        return postImg;
    }

    public void setPostImg(String postImg) {
        this.postImg = postImg;
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
