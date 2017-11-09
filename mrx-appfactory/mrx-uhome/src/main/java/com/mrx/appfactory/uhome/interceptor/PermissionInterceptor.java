package com.mrx.appfactory.uhome.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mrx.appfactory.common.core.APIException;
import com.mrx.appfactory.common.core.APIResults;
import com.mrx.appfactory.common.util.StringUtil;
import com.mrx.appfactory.uhome.entity.AppEntity;
import com.mrx.appfactory.uhome.entity.SignEntity;
import com.mrx.appfactory.uhome.service.IUhomeService;
import com.mrx.appfactory.uhome.util.SecurityUtil;

/**
 * @Type PermissionInterceptor.java
 * @Desc 
 * @author xuwen
 * @date 2017年6月1日 下午3:24:01
 * @version 
 */
public class PermissionInterceptor implements HandlerInterceptor {
    @Autowired
    IUhomeService iUhomeService;

    /**
     * 〈一句话功能简述〉请求拦截器前置
     * 〈功能详细描述〉拦截请求，验证sign
     *
     * @param request  请求
     * @param response 响应
     * @param handler  控制器
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler)
            throws Exception {
        String sign = request.getParameter("sign");
        if (StringUtil.isBlank(sign)) {
            throw new APIException(APIResults.PARAM_INVALID, "没传sign");
        }
        SignEntity signEntity = SecurityUtil.decodeSign(sign);
        AppEntity appEntity = iUhomeService.getAppInfo(signEntity.getAppId());
        if (appEntity == null) {
            throw new APIException(APIResults.FAILED, "该应用ID还未注册");
        }
        if (Math.abs(new Date().getTime() - signEntity.getTime()) > Long
                .parseLong(appEntity.getTimeRule())) {
            throw new APIException(APIResults.FAILED, "服务器时间规则不符");
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
                                Exception arg3)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
                           ModelAndView arg3)
            throws Exception {
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2017年6月1日 xuwen creat
 */
