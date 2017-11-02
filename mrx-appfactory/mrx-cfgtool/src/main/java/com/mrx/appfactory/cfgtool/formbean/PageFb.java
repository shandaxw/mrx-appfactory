package com.mrx.appfactory.cfgtool.formbean;

import java.io.Serializable;

/**
 * @Type ComboFb.java
 * @Desc 
 * @author xuwen
 * @date 2017年6月1日 下午4:32:41
 * @version 
 */
public class PageFb implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;

    /** 
     * datagrid参数：每页显示数量 
     */
    private Integer rows;

    /**
     * datagrid参数：当前页数 
     */
    private Integer page;
    /**
     * 分页偏移
     */
    private Integer offset;

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
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
