package com.mrx.appfactory.gobuild.service;

import com.mrx.appfactory.gobuild.entity.CardEntity;
import com.mrx.appfactory.gobuild.entity.MessageEntity;
import com.mrx.appfactory.gobuild.entity.PageEntity;
import com.mrx.appfactory.gobuild.entity.PostEntity;

/**
 * @Type IGoBuildService.java
 * @Desc 
 * @author xuwen
 * @date 2017年7月20日 下午2:59:00
 * @version 
 */
public interface IGoBuildService {
    /**
     * 〈一句话功能简述〉获取用户名片
     * 〈功能详细描述〉
     *
     * @param userId
     * @return
     * @throws Exception 
     */
    CardEntity getCardInfo(String userId) throws Exception;

    /**
     * 〈一句话功能简述〉获取帖子列表
     * 〈功能详细描述〉
     *
     * @param pageEntity
     * @return
     */
    PageEntity<PostEntity> getPostList(PageEntity<PostEntity> pageEntity);

    /**
     * 〈一句话功能简述〉获取帖子详细
     * 〈功能详细描述〉
     *
     * @param postId
     * @return
     * @throws Exception 
     */
    PostEntity getPostDetail(String postId) throws Exception;

    /**
     * 〈一句话功能简述〉新增交流信息
     * 〈功能详细描述〉
     *
     * @param messageEntity
     */
    void addMessage(MessageEntity messageEntity);

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年7月20日 xuwen create
 */
