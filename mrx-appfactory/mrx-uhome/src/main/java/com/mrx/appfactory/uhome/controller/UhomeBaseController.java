package com.mrx.appfactory.uhome.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrx.appfactory.common.controller.BaseController;
import com.mrx.appfactory.common.core.APIResult;

/**
 * 
 * @Type UhomeBaseController.java
 * @Desc 
 * @author xuwen
 * @date 2017年11月1日 上午10:14:47
 * @version
 */
public class UhomeBaseController extends BaseController {
    /**
     * 〈一句话功能简述〉返回格式转换
     * 〈功能详细描述〉
     *
     * @param throwable
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Throwable.class)
    public APIResult uhHandleException(Throwable throwable) {
        return this.handleException(throwable);

    }

}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年6月1日 xuwen create
 */
