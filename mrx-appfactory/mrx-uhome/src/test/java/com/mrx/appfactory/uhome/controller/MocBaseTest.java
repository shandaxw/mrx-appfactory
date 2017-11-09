package com.mrx.appfactory.uhome.controller;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Log4jConfigurer;

/**
 * @Type MocBaseTest.java
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
