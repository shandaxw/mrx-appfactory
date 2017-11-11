package com.mrx.appfactory.gobuild.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @Type HeadEntity.java
 * @Desc 
 * @author xuwen
 * @date 2017年7月20日 下午3:18:50
 * @version 
 */
public class CardEntity implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
    /**
     * 用户ID
     */
    @JsonInclude(Include.NON_NULL)
    private String userId;
    /**
     * 用户头像
     */
    @JsonInclude(Include.NON_NULL)
    private String userHead;
    /**
     * 座右铭
     */
    @JsonInclude(Include.NON_NULL)
    private String userMotto;
    /**
     * 自我介绍
     */
    @JsonInclude(Include.NON_NULL)
    private String userAbout;
    /**
     * 热门帖子
     */
    @JsonInclude(Include.NON_NULL)
    private List<PostEntity> postList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public List<PostEntity> getPostList() {
        return postList;
    }

    public void setPostList(List<PostEntity> postList) {
        this.postList = postList;
    }

    public String getUserAbout() {
        return userAbout;
    }

    public void setUserAbout(String userAbout) {
        this.userAbout = userAbout;
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
