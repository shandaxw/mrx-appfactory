package com.mrx.appfactory.gobuild.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrx.appfactory.common.core.APIException;
import com.mrx.appfactory.common.core.APIResults;
import com.mrx.appfactory.common.util.Constants;
import com.mrx.appfactory.common.util.RedisUtil;
import com.mrx.appfactory.gobuild.dao.IGoBuildDao;
import com.mrx.appfactory.gobuild.entity.CardEntity;
import com.mrx.appfactory.gobuild.entity.MessageEntity;
import com.mrx.appfactory.gobuild.entity.PageEntity;
import com.mrx.appfactory.gobuild.entity.PostEntity;
import com.mrx.appfactory.gobuild.service.IGoBuildService;

/**
 * @Type GoBuildImpl.java
 * @Desc 
 * @author xuwen
 * @date 2017年7月20日 下午2:59:22
 * @version 
 */
@Service
@Transactional
public class GoBuildImpl implements IGoBuildService {
    @Autowired
    IGoBuildDao iGoBuildDao;
    @Autowired
    RedisUtil redisUtil;

    /**
     * 〈一句话功能简述〉获取用户名片
     * 〈功能详细描述〉
     *
     * @param userId
     * @return
     * @throws Exception 
     */
    @Override
    @Transactional(readOnly = true)
    public CardEntity getCardInfo(String userId) throws Exception {
        Object object = redisUtil.get(Constants.GOBUILD_USER + userId);
        CardEntity cardEntity;
        if (object == null) {
            cardEntity = iGoBuildDao.getCardInfo(userId);
            if (cardEntity == null) {
                throw new APIException(APIResults.FAILED, "用户不存在");
            }
            List<PostEntity> postList = iGoBuildDao.getHotPostList(userId);
            cardEntity.setPostList(postList);
            redisUtil.set(Constants.GOBUILD_USER + userId, cardEntity, Constants.EXPIRE_TIME_DAY_5,
                    TimeUnit.DAYS);
        } else {
            cardEntity = (CardEntity) object;
        }
        return cardEntity;
    }

    /**
     * 〈一句话功能简述〉获取帖子列表
     * 〈功能详细描述〉
     *
     * @param userId
     * @param pageEntity
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public PageEntity<PostEntity> getPostList(PageEntity<PostEntity> pageEntity) {
        Integer total = iGoBuildDao.getPostTotal(pageEntity.getUserId());
        if (total == 0) {
            return pageEntity;
        }
        pageEntity.setTotalCount(total);
        pageEntity.setOffset(pageEntity.getPageNum() * pageEntity.getPageSize());
        List<PostEntity> dataList = iGoBuildDao.getPostList(pageEntity);
        pageEntity.setDataList(dataList);
        return pageEntity;
    }

    /**
     * 〈一句话功能简述〉获取帖子详细
     * 〈功能详细描述〉
     *
     * @param postId
     * @return
     * @throws Exception 
     */
    @Override
    @Transactional(readOnly = true)
    public PostEntity getPostDetail(String postId) throws Exception {
        Object object = redisUtil.get(Constants.GOBUILD_POST + postId);
        PostEntity postEntity;
        if (object == null) {
            postEntity = iGoBuildDao.getPostDetail(postId);
            if (postEntity == null) {
                throw new APIException(APIResults.FAILED, "帖子不存在");
            }
            redisUtil.set(Constants.GOBUILD_POST + postId, postEntity, Constants.EXPIRE_TIME_DAY_5,
                    TimeUnit.DAYS);
        } else {
            postEntity = (PostEntity) object;
        }
        return postEntity;
    }

    /**
     * 〈一句话功能简述〉新增交流信息
     * 〈功能详细描述〉
     *
     * @param messageEntity
     */
    @Override
    public void addMessage(MessageEntity messageEntity) {
        iGoBuildDao.addMessage(messageEntity);
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
