package com.mrx.appfactory.uhome.dao;

import com.mrx.appfactory.uhome.entity.AppEntity;
import com.mrx.appfactory.uhome.entity.UserEntity;

/**
 * @Type IUhomeDao.java
 * @Desc 
 * @author xuwen
 * @date 2017年7月20日 下午3:00:29
 * @version 
 */
public interface IUhomeDao {
    /**
     * 〈一句话功能简述〉获取用户信息
     * 〈功能详细描述〉
     *
     * @param userEntity
     * @return
     */
    UserEntity getUserInfo(UserEntity userEntity);

    /**
     * 〈一句话功能简述〉获取APP信息
     * 〈功能详细描述〉
     *
     * @param appId
     * @return
     */
    AppEntity getAppInfo(String appId);

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年7月20日 xuwen create
 */
