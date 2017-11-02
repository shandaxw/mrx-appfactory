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
package com.mrx.appfactory.cfgtool.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.mrx.appfactory.cfgtool.formbean.ConfigListFb;
import com.mrx.appfactory.cfgtool.service.IConfigToolService;

/**
 * @Type ConfigToolControllerTest.java
 * @Desc 
 * @author xuwen
 * @date 2017年7月24日 下午4:57:47
 * @version 
 */
public class ConfigToolControllerTest extends MocBaseTest {
    @InjectMocks
    ConfigToolController configToolController;
    @Mock
    IConfigToolService iConfigToolService;

    /**
     * 〈一句话功能简述〉查询编号是否存在
     * 〈功能详细描述〉
     *
     * @param apiNo
     * @return
     * @throws Exception
     */
    @Test
    public void testIsNumExist() throws Exception {
        //        when(iConfigToolService.getConfigCountByNo(anyString())).thenReturn(10);
        //        Object object = configToolController.isNumExist("test003");
        //        assertNotNull(object);
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
    public void testConfigList() throws Exception {
        ConfigListFb configListFb = new ConfigListFb();
        configListFb.setRows(10);
        configListFb.setPage(1);
        when(iConfigToolService.getConfigList(configListFb))
                .thenReturn(new HashMap<String, Object>());
        Object object = configToolController.configList(configListFb);
        assertNotNull(object);
    }

    /**
     * 〈一句话功能简述〉保存配置
     * 〈功能详细描述〉
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Test
    public void testSave() throws Exception {
        //        MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();
        //        String boundary = "q1w2e3r4t5y6u7i8o9";
        //        request.setContentType("multipart/form-data; boundary=" + boundary);
        //        request.addFile(new MockMultipartFile("boundary", new byte[8192]));
        //        configToolController.save(request);
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
    public void testUpdate() throws Exception {
        //        MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();
        //        String boundary = "q1w2e3r4t5y6u7i8o9";
        //        request.setContentType("multipart/form-data; boundary=" + boundary);
        //        request.addFile(new MockMultipartFile("boundary", new byte[8192]));
        //        configToolController.update(request);
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
    public void testConfig() throws Exception {
        //        when(iConfigToolService.getConfigByNo("test003")).thenReturn(new ConfigEntity());
        //        Object object = configToolController.config("test003");
        //        assertNotNull(object);
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
    public void testDelete() throws Exception {
        //        Object object = configToolController.delete(1l);
        //        assertNotNull(object);
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testInitBinder() throws Exception {
        //        MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();
        //        String boundary = "q1w2e3r4t5y6u7i8o9";
        //        request.setContentType("multipart/form-data; boundary=" + boundary);
        //        request.addFile(new MockMultipartFile("boundary", new byte[8192]));
        //        configToolController.initBinder(request, new ServletRequestDataBinder(boundary));
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testHandleExceptionForDHome() throws Exception {
        //        configToolController
        //                .handleExceptionForDHome(new APIException(APIExceptions.FAILED, "ioId参数没传"));
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testHandleException() throws Exception {
        //        configToolController
        //                .handleExceptionForDHome(new APIException(APIExceptions.FAILED, "ioId参数没传"));
        //        configToolController.handleExceptionForDHome(new Exception());
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
