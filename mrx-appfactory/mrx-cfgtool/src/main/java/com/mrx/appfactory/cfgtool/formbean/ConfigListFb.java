package com.mrx.appfactory.cfgtool.formbean;

/**
 * @Type ConfigFb.java
 * @Desc 
 * @author xuwen
 * @date 2017年7月20日 下午3:21:54
 * @version 
 */
public class ConfigListFb extends PageFb {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
    /**
     * 接口名称
     */
    private String apiName;
    /**
     * 接口编号
     */
    private String apiNo;

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiNo() {
        return apiNo;
    }

    public void setApiNo(String apiNo) {
        this.apiNo = apiNo;
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
