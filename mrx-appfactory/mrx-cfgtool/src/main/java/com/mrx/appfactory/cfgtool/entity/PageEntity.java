package com.mrx.appfactory.cfgtool.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Type ComboFb.java
 * @Desc 
 * @author xuwen
 * @date 2017年6月1日 下午4:32:41
 * @version 
 */
public class PageEntity<T> implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 分页大小
     */
    private Integer pageSize;
    /**
     * 当前页
     */
    private Integer pageNum;
    /**
     * 总记录数
     */
    private Integer totalCount;
    /**
     * 数据
     */
    private List<T> dataList;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
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
