package com.mrx.appfactory.cfgtool.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrx.appfactory.cfgtool.dao.IConfigToolDao;
import com.mrx.appfactory.cfgtool.entity.ConfigEntity;
import com.mrx.appfactory.cfgtool.formbean.ConfigListFb;
import com.mrx.appfactory.cfgtool.service.IConfigToolService;

/**
 * @Type ConfigToolServiceImpl.java
 * @Desc 
 * @author xuwen
 * @date 2017年7月20日 下午2:59:22
 * @version 
 */
@Service
@Transactional
public class ConfigToolServiceImpl implements IConfigToolService {
    @Autowired
    IConfigToolDao iConfigToolDao;

    /**
     * 〈一句话功能简述〉查询编号是否存在
     * 〈功能详细描述〉
     *
     * @param apiNo
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(readOnly = true)
    public Integer getConfigCountByNo(String apiNo) {
        return iConfigToolDao.getConfigCountByNo(apiNo);
    }

    /**
     * 〈一句话功能简述〉查询配置列表
     * 〈功能详细描述〉
     *
     * @param configListFb
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> getConfigList(ConfigListFb configListFb) {
        Integer pageSize = configListFb.getRows();
        Integer pageNum = configListFb.getPage();
        Integer offset = (pageNum - 1) * pageSize;
        if (configListFb.getApiName() != null) {
            configListFb.setApiName("%" + configListFb.getApiName() + "%");
        }
        if (configListFb.getApiNo() != null) {
            configListFb.setApiNo("%" + configListFb.getApiNo() + "%");
        }
        Integer total = iConfigToolDao.getConfigTotal(configListFb);
        configListFb.setOffset(offset);
        List<ConfigEntity> dataList = iConfigToolDao.getConfigList(configListFb);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", dataList);
        return map;
    }

    /**
     * 〈一句话功能简述〉根据编号查询配置
     * 〈功能详细描述〉
     *
     * @param apiNo
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(readOnly = true)
    public ConfigEntity getConfigByNo(String apiNo) {
        return iConfigToolDao.getConfigByNo(apiNo);
    }

    /**
     * 〈一句话功能简述〉保存配置
     * 〈功能详细描述〉
     *
     * @param items
     * @return
     * @throws Exception
     */
    @Override
    public void addConfig(List<FileItem> items) throws Exception {
        ConfigEntity configEntity = new ConfigEntity();
        Map<String, String> htmlMap = new HashMap<>();
        Map<String, String> fileMap = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Iterator<FileItem> iter = items.iterator();
        int index = 0;
        while (iter.hasNext()) {
            FileItem item = iter.next();
            if (item.isFormField()) {
                //如果是普通表单字段
                String name = item.getFieldName();
                String value = item.getString("UTF-8");
                if ("apiName".equals(name)) {
                    configEntity.setApiName(value);
                } else if ("apiNo".equals(name)) {
                    configEntity.setApiNo(value);
                } else if ("jsonData".equals(name)) {
                    configEntity.setJsonData(value);
                } else if ("jsonString".equals(name)) {
                    configEntity.setJsonString(value);
                } else {
                    htmlMap.put(name, value);
                }
            } else {
                //如果是文件字段
                String fieldName = item.getFieldName();
                String fileName = item.getName();
                fileName = sdf.format(new Date()) + String.valueOf(index) + "."
                        + fileName.split("\\.")[1];
                index++;
                fileMap.put(fieldName, fileName);
                transferFile(item, fileName);
            }
        }
        String json = configEntity.getJsonData();
        //替换json中的file的值
        for (Entry<String, String> entry : fileMap.entrySet()) {
            json = json.replace("[#" + entry.getKey() + "]", entry.getValue());
        }
        //替换json中的html的值
        for (Entry<String, String> entry : htmlMap.entrySet()) {
            json = json.replace("[#" + entry.getKey() + "]", entry.getValue());
        }
        configEntity.setJsonData(json);
        iConfigToolDao.addConfig(configEntity);
    }

    /**
     * 〈一句话功能简述〉保存文件
     * 〈功能详细描述〉
     *
     * @param item
     * @param fileName
     * @throws Exception
     */
    private void transferFile(FileItem item, String fileName) throws Exception {
        String path = "/usr/local/src";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        File newFile = new File(path + "/" + fileName);
        item.write(newFile);
    }

    /**
     * 〈一句话功能简述〉删除配置
     * 〈功能详细描述〉
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public void deleteConfig(Long id) {
        iConfigToolDao.deleteConfig(id);
    }

    /**
     * 〈一句话功能简述〉更新配置
     * 〈功能详细描述〉
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public void updateConfig(List<FileItem> items) throws Exception {
        ConfigEntity configEntity = new ConfigEntity();
        Map<String, String> htmlMap = new HashMap<>();
        Map<String, String> fileMap = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Iterator<FileItem> iter = items.iterator();
        int index = 0;
        while (iter.hasNext()) {
            FileItem item = iter.next();
            if (item.isFormField()) {
                //如果是普通表单字段
                String name = item.getFieldName();
                String value = item.getString("UTF-8");
                if ("apiName".equals(name)) {
                    configEntity.setApiName(value);
                } else if ("apiNo".equals(name)) {
                    configEntity.setApiNo(value);
                } else if ("jsonData".equals(name)) {
                    configEntity.setJsonData(value);
                } else if ("jsonString".equals(name)) {
                    configEntity.setJsonString(value);
                } else {
                    htmlMap.put(name, value);
                }
            } else {
                //如果是文件字段
                String fieldName = item.getFieldName();
                String fileName = item.getName();
                fileName = sdf.format(new Date()) + String.valueOf(index) + "."
                        + fileName.split("\\.")[1];
                index++;
                fileMap.put(fieldName, fileName);
                transferFile(item, fileName);
            }
        }
        String json = configEntity.getJsonData();
        //替换json中的file的值
        for (Entry<String, String> entry : fileMap.entrySet()) {
            json = json.replace("[#" + entry.getKey() + "]", entry.getValue());
        }
        //替换json中的html的值
        for (Entry<String, String> entry : htmlMap.entrySet()) {
            json = json.replace("[#" + entry.getKey() + "]", entry.getValue());
        }
        configEntity.setJsonData(json);
        iConfigToolDao.updateConfig(configEntity);
    }

    /**
     * 〈一句话功能简述〉根据编号获取接口数据
     * 〈功能详细描述〉
     *
     * @param apiNo
     * @return
     */
    @Override
    public String getJsonDataByNo(String apiNo) {
        return iConfigToolDao.getJsonDataByNo(apiNo);
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
