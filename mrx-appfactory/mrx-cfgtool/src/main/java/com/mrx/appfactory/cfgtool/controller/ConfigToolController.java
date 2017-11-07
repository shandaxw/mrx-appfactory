package com.mrx.appfactory.cfgtool.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrx.appfactory.cfgtool.entity.ConfigEntity;
import com.mrx.appfactory.cfgtool.formbean.ConfigListFb;
import com.mrx.appfactory.cfgtool.service.IConfigToolService;
import com.mrx.appfactory.common.core.APIResult;
import com.mrx.appfactory.common.core.APIResults;

/**
 * @Type ConfigToolController.java
 * @Desc 
 * @author xuwen
 * @date 2017年7月20日 下午2:45:06
 * @version 
 */
@Controller
@RequestMapping("/configTool")
public class ConfigToolController extends CfgToolBaseController {
    @Autowired
    IConfigToolService iConfigToolService;

    /**
     * 〈一句话功能简述〉查询编号是否存在
     * 〈功能详细描述〉
     *
     * @param apiNo
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/isNumExist/{apiNo}", method = RequestMethod.GET)
    public APIResult isNumExist(@PathVariable String apiNo) throws Exception {
        Integer count = iConfigToolService.getConfigCountByNo(apiNo);
        return APIResult.getResult(APIResults.SUCCESS, count);
    }

    /**
     * 〈一句话功能简述〉查询配置列表
     * 〈功能详细描述〉
     *
     * @param configListFb
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/configList", method = RequestMethod.GET)
    public Object configList(ConfigListFb configListFb) throws Exception {
        Map<String, Object> map = iConfigToolService.getConfigList(configListFb);
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
    @ResponseBody
    @RequestMapping(value = "/config/{apiNo}", method = RequestMethod.GET)
    public APIResult config(@PathVariable String apiNo) throws Exception {
        ConfigEntity configEntity = iConfigToolService.getConfigByNo(apiNo);
        return APIResult.getResult(APIResults.SUCCESS, configEntity);
    }

    /**
     * 〈一句话功能简述〉根据编号获取接口数据
     * 〈功能详细描述〉
     *
     * @param apiNo
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/jsonData/{apiNo}", method = RequestMethod.GET)
    public String jsonData(@PathVariable String apiNo) throws Exception {
        return iConfigToolService.getJsonDataByNo(apiNo);
    }

    /**
     * 〈一句话功能简述〉保存配置
     * 〈功能详细描述〉
     *
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public APIResult save(HttpServletRequest request) throws Exception {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        List<FileItem> items = upload.parseRequest(request);
        iConfigToolService.addConfig(items);
        return APIResult.getResult(APIResults.SUCCESS);
    }

    /**
     * 〈一句话功能简述〉更新配置
     * 〈功能详细描述〉
     *
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public APIResult update(HttpServletRequest request) throws Exception {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        List<FileItem> items = upload.parseRequest(request);
        iConfigToolService.updateConfig(items);
        return APIResult.getResult(APIResults.SUCCESS);
    }

    /**
     * 〈一句话功能简述〉删除配置
     * 〈功能详细描述〉
     *
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public APIResult delete(@PathVariable Long id) throws Exception {
        iConfigToolService.deleteConfig(id);
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
