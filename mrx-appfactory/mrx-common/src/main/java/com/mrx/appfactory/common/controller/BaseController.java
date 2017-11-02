package com.mrx.appfactory.common.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.mrx.appfactory.common.core.APIException;
import com.mrx.appfactory.common.core.APIResult;
import com.mrx.appfactory.common.core.APIResults;

/**
 * 
 * @author xuwen
 *
 */
public class BaseController {

    private static final Logger logger = Logger.getLogger(BaseController.class);

    /**
     * 〈一句话功能简述〉异常处理
     * 〈功能详细描述〉
     *
     * @param throwable
     * @return
     */
    public APIResult handleException(Throwable throwable) {
        if (throwable instanceof APIException) {
            logger.info("APIEXCEPTION", throwable);
            APIException apiException = (APIException) throwable;
            return new APIResult(apiException.getException(), apiException.getMessage());
        } else if (throwable instanceof DataAccessException) {
            logger.error("数据库异常", throwable);
            return new APIResult(APIResults.DATABASE_EXCEPTION,
                    "服务器异常:" + APIResults.DATABASE_EXCEPTION.getCode());
        } else {
            logger.error("其他错误", throwable);
            return new APIResult(APIResults.ELSE, "服务器异常:" + APIResults.ELSE.getCode());
        }

    }

    /**
     * 〈一句话功能简述〉表单参数绑定
     * 〈功能详细描述〉
     *
     * @param request
     * @param binder
     * @throws Exception
     */
    @InitBinder
    public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
            throws Exception {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }

}
