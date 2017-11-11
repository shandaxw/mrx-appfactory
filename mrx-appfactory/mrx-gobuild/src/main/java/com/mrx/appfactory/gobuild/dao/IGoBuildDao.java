package com.mrx.appfactory.gobuild.dao;

import java.util.List;

import com.mrx.appfactory.gobuild.entity.CardEntity;
import com.mrx.appfactory.gobuild.entity.MessageEntity;
import com.mrx.appfactory.gobuild.entity.PageEntity;
import com.mrx.appfactory.gobuild.entity.PostEntity;

/**
 * @Type IGoBuildDao.java
 * @Desc 
 * @author xuwen
 * @date 2017年7月20日 下午3:00:29
 * @version 
 */
public interface IGoBuildDao {
    /**
     * 〈一句话功能简述〉获取头像
     * 〈功能详细描述〉
     *
     * @param userId
     * @return
     */
    CardEntity getCardInfo(String userId);

    /**
     * 〈一句话功能简述〉获取热门帖子
     * 〈功能详细描述〉
     *
     * @param userId
     * @return
     */
    List<PostEntity> getHotPostList(String userId);

    /**
     * 〈一句话功能简述〉获取该用户的帖子总数
     * 〈功能详细描述〉
     *
     * @param userId
     * @return
     */
    Integer getPostTotal(String userId);

    /**
     * 〈一句话功能简述〉分页获取帖子
     * 〈功能详细描述〉
     *
     * @param pageEntity
     * @return
     */
    List<PostEntity> getPostList(PageEntity<PostEntity> pageEntity);

    /**
     * 〈一句话功能简述〉获取帖子详细
     * 〈功能详细描述〉
     *
     * @param postId
     * @return
     */
    PostEntity getPostDetail(String postId);

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
