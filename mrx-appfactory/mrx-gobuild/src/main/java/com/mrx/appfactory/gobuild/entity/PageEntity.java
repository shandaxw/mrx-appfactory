package com.mrx.appfactory.gobuild.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @Type PageEntity.java
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
     * 用户ID
     */
    @JsonInclude(Include.NON_NULL)
    private String userId;
    /**
     * 分页大小
     */
    private Integer pageSize = 5;
    /**
     * 当前页
     */
    private Integer pageNum = 0;
    /**
     * 总记录数
     */
    private Integer totalCount;
    /**
     * 偏移
     */
    private Integer offset;
    /**
     * 数据
     */
    @JsonInclude(Include.NON_NULL)
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

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
