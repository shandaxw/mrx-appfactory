/*
 * Project: cmcc-cfgtool
 * 
 * File Created at 2017年7月24日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.mrx.appfactory.cfgtool.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.mrx.appfactory.cfgtool.controller.MocBaseTest;
import com.mrx.appfactory.cfgtool.dao.IConfigToolDao;
import com.mrx.appfactory.cfgtool.entity.ConfigEntity;
import com.mrx.appfactory.cfgtool.formbean.ConfigListFb;
import com.mrx.appfactory.cfgtool.service.impl.ConfigToolServiceImpl;

/**
 * @Type ConfigToolServiceImplTest.java
 * @Desc 
 * @author xuwen
 * @date 2017年7月24日 下午3:58:26
 * @version 
 */
public class ConfigToolServiceImplTest extends MocBaseTest {
    @InjectMocks
    ConfigToolServiceImpl configToolServiceImpl;
    @Mock
    IConfigToolDao iConfigToolDao;

    /**
     * 〈一句话功能简述〉查询编号是否存在
     * 〈功能详细描述〉
     *
     * @param apiNo
     * @return
     * @throws Exception
     */
    @Test
    public void testGetConfigCountByNo() {
        when(iConfigToolDao.getConfigCountByNo(anyString())).thenReturn(10);
        Integer count = configToolServiceImpl.getConfigCountByNo("test001");
        assertTrue(count == 10);
    }

    /**
     * 〈一句话功能简述〉查询配置列表
     * 〈功能详细描述〉
     *
     * @param configListFb
     * @return
     * @throws Exception
     */
    @Test
    public void testGetConfigList() {
        ConfigListFb configListFb = new ConfigListFb();
        configListFb.setRows(10);
        configListFb.setPage(1);
        configListFb.setApiName("fsdf");
        configListFb.setApiNo("111");
        when(iConfigToolDao.getConfigTotal(configListFb)).thenReturn(10);
        when(iConfigToolDao.getConfigList(configListFb)).thenReturn(new ArrayList<ConfigEntity>());
        Map<String, Object> map = configToolServiceImpl.getConfigList(configListFb);
        assertNotNull(map);
    }

    /**
     * 〈一句话功能简述〉根据编号查询配置
     * 〈功能详细描述〉
     *
     * @param apiNo
     * @return
     * @throws Exception
     */
    @Test
    public void testGetConfigByNo() {
        ConfigEntity config = new ConfigEntity();
        when(iConfigToolDao.getConfigByNo("test003")).thenReturn(config);
        ConfigEntity configEntity = configToolServiceImpl.getConfigByNo("test003");
        assertNotNull(configEntity);
    }

    /**
     * 〈一句话功能简述〉保存配置
     * 〈功能详细描述〉
     *
     * @param items
     * @return
     * @throws Exception
     */
    @Test
    public void testAddConfig() throws Exception {
        List<FileItem> items = new ArrayList<>();
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        FileItem fileItem = factory.createItem("apiName", "utf-8", true, "8");
        OutputStream os = fileItem.getOutputStream();
        os.write(new byte[8192]);
        items.add(fileItem);
        fileItem = factory.createItem("apiNo", "utf-8", true, "8");
        os = fileItem.getOutputStream();
        os.write(new byte[8192]);
        items.add(fileItem);
        fileItem = factory.createItem("jsonData", "utf-8", true, "8");
        os = fileItem.getOutputStream();
        os.write(new byte[8192]);
        items.add(fileItem);
        fileItem = factory.createItem("jsonString", "utf-8", true, "8");
        os = fileItem.getOutputStream();
        os.write(new byte[8192]);
        items.add(fileItem);
        fileItem = factory.createItem("html", "utf-8", true, "8");
        os = fileItem.getOutputStream();
        os.write(new byte[8192]);
        items.add(fileItem);
        configToolServiceImpl.addConfig(items);
    }

    /**
     * 〈一句话功能简述〉删除配置
     * 〈功能详细描述〉
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Test
    public void testDeleteConfig() {
        configToolServiceImpl.deleteConfig(1l);
    }

    /**
     * 〈一句话功能简述〉更新配置
     * 〈功能详细描述〉
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Test
    public void testUpdateConfig() throws Exception {
        List<FileItem> items = new ArrayList<>();
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        FileItem fileItem = factory.createItem("apiName", "utf-8", true, "8");
        OutputStream os = fileItem.getOutputStream();
        os.write(new byte[8192]);
        items.add(fileItem);
        fileItem = factory.createItem("apiNo", "utf-8", true, "8");
        os = fileItem.getOutputStream();
        os.write(new byte[8192]);
        items.add(fileItem);
        fileItem = factory.createItem("jsonData", "utf-8", true, "8");
        os = fileItem.getOutputStream();
        os.write(new byte[8192]);
        items.add(fileItem);
        fileItem = factory.createItem("jsonString", "utf-8", true, "8");
        os = fileItem.getOutputStream();
        os.write(new byte[8192]);
        items.add(fileItem);
        fileItem = factory.createItem("html", "utf-8", true, "8");
        os = fileItem.getOutputStream();
        os.write(new byte[8192]);
        items.add(fileItem);
        configToolServiceImpl.updateConfig(items);
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年7月24日 xuwen creat
 */
