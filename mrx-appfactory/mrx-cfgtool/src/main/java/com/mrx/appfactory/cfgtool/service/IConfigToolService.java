package com.mrx.appfactory.cfgtool.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import com.mrx.appfactory.cfgtool.entity.ConfigEntity;
import com.mrx.appfactory.cfgtool.formbean.ConfigListFb;

/**
 * @Type IConfigToolService.java
 * @Desc 
 * @author xuwen
 * @date 2017年7月20日 下午2:59:00
 * @version 
 */
public interface IConfigToolService {
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
     * 〈一句话功能简述〉查询配置列表
     * 〈功能详细描述〉
     *
     * @param configListFb
     * @return
     * @throws Exception
     */
    Map<String, Object> getConfigList(ConfigListFb configListFb);

    /**
     * 〈一句话功能简述〉根据编号查询配置
     * 〈功能详细描述〉
     *
     * @param apiNo
     * @return
     * @throws Exception
     */
    ConfigEntity getConfigByNo(String apiNo);

    /**
     * 〈一句话功能简述〉保存配置
     * 〈功能详细描述〉
     *
     * @param items
     * @return
     * @throws Exception
     */
    void addConfig(List<FileItem> items) throws Exception;

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
    void updateConfig(List<FileItem> items) throws Exception;

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
