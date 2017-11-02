/*
 * Project: cmcc-common
 * 
 * File Created at 2017年6月20日
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

import java.io.FileNotFoundException;

import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Log4jConfigurer;

/**
 * @Type BaseSpringTestCase.java
 * @Desc 
 * @author xuwen
 * @date 2017年6月20日 上午9:47:05
 * @version 
 */
public class MocBaseTest {
    static {
        try {
            Log4jConfigurer.initLogging("classpath:conf/log4j.properties");
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot Initialize log4j");
        }
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年6月20日 xuwen creat
 */
