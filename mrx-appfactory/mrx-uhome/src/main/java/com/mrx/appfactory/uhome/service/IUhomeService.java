package com.mrx.appfactory.uhome.service;

import com.mrx.appfactory.uhome.entity.AppEntity;
import com.mrx.appfactory.uhome.entity.UserEntity;

/**
 * @Type IUhomeService.java
 * @Desc 
 * @author xuwen
 * @date 2017年7月20日 下午2:59:00
 * @version 
 */
public interface IUhomeService {
    /**
     * 〈一句话功能简述〉用户登录
     * 〈功能详细描述〉
     *
     * @param userEntity
     * @return 
     * @throws Exception 
     */
    String login(UserEntity userEntity) throws Exception;

    /**
     * 〈一句话功能简述〉获取用户信息
     * 〈功能详细描述〉
     *
     * @param sign
     * @return
     * @throws Exception 
     */
    UserEntity getUserInfo(String sign) throws Exception;

    /**
     * 〈一句话功能简述〉获取APP信息
     * 〈功能详细描述〉
     *
     * @param appId
     * @return
     */
    AppEntity getAppInfo(String appId);

    /**
     * 〈一句话功能简述〉刷新token
     * 〈功能详细描述〉
     *
     * @param parameter
     * @throws Exception 
     */
    void refreshToken(String parameter) throws Exception;

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年7月20日 xuwen create
 */
