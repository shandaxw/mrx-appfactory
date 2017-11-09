package com.mrx.appfactory.uhome.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrx.appfactory.common.core.APIException;
import com.mrx.appfactory.common.core.APIResults;
import com.mrx.appfactory.uhome.dao.IUhomeDao;
import com.mrx.appfactory.uhome.entity.AppEntity;
import com.mrx.appfactory.uhome.entity.SignEntity;
import com.mrx.appfactory.uhome.entity.UserEntity;
import com.mrx.appfactory.uhome.service.IUhomeService;
import com.mrx.appfactory.uhome.util.RedisUtil;
import com.mrx.appfactory.uhome.util.SecurityUtil;

/**
 * @Type UhomeImpl.java
 * @Desc 
 * @author xuwen
 * @date 2017年7月20日 下午2:59:22
 * @version 
 */
@Service
@Transactional
public class UhomeImpl implements IUhomeService {
    @Autowired
    IUhomeDao iUhomeDao;
    @Autowired
    RedisUtil redisUtil;

    /**
     * 〈一句话功能简述〉用户登录
     * 〈功能详细描述〉
     *
     * @param userEntity
     * @throws Exception
     */
    @Override
    public String login(UserEntity userEntity) throws Exception {
        UserEntity user = iUhomeDao.getUserInfo(userEntity);
        if (user == null) {
            throw new APIException(APIResults.FAILED, "帐号不存在");
        }
        if (!user.getPassword().equals(userEntity.getPassword())) {
            throw new APIException(APIResults.FAILED, "密码不正确");
        }
        String token = SecurityUtil.createToken(userEntity.getAccount());
        redisUtil.set(token, user);
        return token;
    }

    /**
     * 〈一句话功能简述〉获取用户信息
     * 〈功能详细描述〉
     *
     * @param sign
     * @return
     * @throws Exception 
     */
    @Override
    public UserEntity getUserInfo(String sign) throws Exception {
        SignEntity signEntity = SecurityUtil.decodeSign(sign);
        UserEntity userEntity = (UserEntity) redisUtil.get(signEntity.getToken());
        if (userEntity == null) {
            throw new APIException(APIResults.FAILED, "未登录或token已过期");
        }
        return userEntity;
    }

    /**
     * 〈一句话功能简述〉获取APP信息
     * 〈功能详细描述〉
     *
     * @param appId
     * @return
     */
    @Override
    public AppEntity getAppInfo(String appId) {
        return iUhomeDao.getAppInfo(appId);
    }

    /**
     * 〈一句话功能简述〉刷新token
     * 〈功能详细描述〉
     *
     * @param parameter
     * @throws Exception 
     */
    @Override
    public void refreshToken(String sign) throws Exception {
        SignEntity signEntity = SecurityUtil.decodeSign(sign);
        UserEntity userEntity = (UserEntity) redisUtil.get(signEntity.getToken());
        if (userEntity == null||redisUtil.expire(signEntity.getToken())) {
            throw new APIException(APIResults.FAILED, "未登录或token已过期");
        }
        
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
