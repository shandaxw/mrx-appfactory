package com.mrx.appfactory.uhome.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrx.appfactory.common.core.APIResult;
import com.mrx.appfactory.common.core.APIResults;
import com.mrx.appfactory.uhome.entity.UserEntity;
import com.mrx.appfactory.uhome.service.IUhomeService;

/**
 * @Type UhomeController.java
 * @Desc 
 * @author xuwen
 * @date 2017年7月20日 下午2:45:06
 * @version 
 */
@Controller
@RequestMapping("/uhome")
public class UhomeController extends UhomeBaseController {
    @Autowired
    IUhomeService iUhomeService;

    /**
     * 〈一句话功能简述〉用户登录
     * 〈功能详细描述〉
     *
     * @param userEntity
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public APIResult login(@Valid UserEntity userEntity, BindingResult bindingResult)
            throws Exception {
        String token = iUhomeService.login(userEntity);
        return APIResult.getResult(APIResults.SUCCESS, token);
    }

    /**
     * 〈一句话功能简述〉获取用户信息
     * 〈功能详细描述〉
     *
     * @param token
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    public APIResult userInfo(HttpServletRequest request) throws Exception {
        UserEntity userEntity = iUhomeService.getUserInfo(request.getParameter("sign"));
        return APIResult.getResult(APIResults.SUCCESS, userEntity);
    }

    /**
     * 〈一句话功能简述〉刷新token
     * 〈功能详细描述〉
     *
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/refreshToken", method = RequestMethod.POST)
    public APIResult refreshToken(HttpServletRequest request) throws Exception {
        iUhomeService.refreshToken(request.getParameter("sign"));
        return APIResult.getResult(APIResults.SUCCESS);
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
