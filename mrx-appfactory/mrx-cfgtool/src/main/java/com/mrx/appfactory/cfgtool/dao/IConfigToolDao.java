package com.mrx.appfactory.cfgtool.dao;

import java.util.List;

import com.mrx.appfactory.cfgtool.entity.ConfigEntity;
import com.mrx.appfactory.cfgtool.formbean.ConfigListFb;

/**
 * @Type IConfigToolDao.java
 * @Desc 
 * @author xuwen
 * @date 2017年7月20日 下午3:00:29
 * @version 
 */
public interface IConfigToolDao {
    /**
     * 〈一句话功能简述〉查询编号是否存在
     * 〈功能详细描述〉
     *
     * @param apiNo
     * @return
     * @throws Exception
     */
    Integer getConfigCountByNo(String apiNo);

    /**
     * 〈一句话功能简述〉查询列表总数
     * 〈功能详细描述〉
     *
     * @param configFb
     * @return
     */
    Integer getConfigTotal(ConfigListFb configFb);

    /**
     * 〈一句话功能简述〉查询列表数据
     * 〈功能详细描述〉
     *
     * @param configFb
     * @return
     */
    List<ConfigEntity> getConfigList(ConfigListFb configFb);

    /**
     * 〈一句话功能简述〉根据编号查询配置
     * 〈功能详细描述〉
     *
     * @param apiNo
     * @return
     */
    ConfigEntity getConfigByNo(String apiNo);

    /**
     * 〈一句话功能简述〉保存配置
     * 〈功能详细描述〉
     *
     * @param configEntity
     * @return
     */
    void addConfig(ConfigEntity configEntity);

    /**
     * 〈一句话功能简述〉删除配置
     * 〈功能详细描述〉
     *
     * @param id
     * @return
     * @throws Exception
     */
    void deleteConfig(Long id);

    /**
     * 〈一句话功能简述〉更新配置
     * 〈功能详细描述〉
     *
     * @param request
     * @return
     * @throws Exception
     */
    void updateConfig(ConfigEntity configEntity);

    /**
     * 〈一句话功能简述〉根据编号获取接口数据
     * 〈功能详细描述〉
     *
     * @param apiNo
     * @return
     */
    String getJsonDataByNo(String apiNo);

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年7月20日 xuwen create
 */
