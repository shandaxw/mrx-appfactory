package com.mrx.appfactory.gobuild.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrx.appfactory.common.core.APIResult;
import com.mrx.appfactory.common.core.APIResults;
import com.mrx.appfactory.gobuild.entity.CardEntity;
import com.mrx.appfactory.gobuild.entity.MessageEntity;
import com.mrx.appfactory.gobuild.entity.PageEntity;
import com.mrx.appfactory.gobuild.entity.PostEntity;
import com.mrx.appfactory.gobuild.service.IGoBuildService;

/**
 * @Type GoBuildController.java
 * @Desc 
 * @author xuwen
 * @date 2017年7月20日 下午2:45:06
 * @version 
 */
@Controller
@RequestMapping("/gobuild")
public class GoBuildController extends GoBuildBaseController {
    @Autowired
    IGoBuildService iGoBuildService;

    /**
     * 〈一句话功能简述〉获取用户名片
     * 〈功能详细描述〉
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/{userId}/cardInfo", method = RequestMethod.GET)
    public APIResult cardInfo(@PathVariable String userId) throws Exception {
        CardEntity cardEntity = iGoBuildService.getCardInfo(userId);
        return APIResult.getResult(APIResults.SUCCESS, cardEntity);
    }

    /**
     * 〈一句话功能简述〉获取帖子列表
     * 〈功能详细描述〉
     *
     * @param userId
     * @param pageEntity
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/{userId}/postList", method = RequestMethod.GET)
    public APIResult postList(@PathVariable String userId, PageEntity<PostEntity> pageEntity)
            throws Exception {
        pageEntity.setUserId(userId);
        PageEntity<PostEntity> data = iGoBuildService.getPostList(pageEntity);
        return APIResult.getResult(APIResults.SUCCESS, data);
    }

    /**
     * 〈一句话功能简述〉获取帖子详细
     * 〈功能详细描述〉
     *
     * @param postId
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/{postId}/postDetail", method = RequestMethod.GET)
    public APIResult postDetail(@PathVariable String postId) throws Exception {
        PostEntity postEntity = iGoBuildService.getPostDetail(postId);
        return APIResult.getResult(APIResults.SUCCESS, postEntity);
    }

    /**
     * 〈一句话功能简述〉新增交流信息
     * 〈功能详细描述〉
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/newMessage", method = RequestMethod.POST)
    public APIResult newMessage(@Valid MessageEntity messageEntity, BindingResult bindingResult)
            throws Exception {
        iGoBuildService.addMessage(messageEntity);
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
