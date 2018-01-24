package org.dmm.entity;

/**
 * Created by Administrator on 2018/1/24 0024.
 */

public class PageEntity {

    private static final long serialVersionUID = -4527112189386545207L;
    // 当前页
    private Integer pageIndex;
    // 每页条数
    private Integer pageSize;
    // 开始记录
    @SuppressWarnings("unused")
    private Integer pageStart;

    // null或者0分页；1：不分页
    private Integer all;
    private String startDate;
    private String endDate;
    // 排序字段
    private String sortField;
    // desc or asc
    private String orderType;

    public Integer getPageIndex() {
        if (pageIndex == null) {
            return 0;
        }
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        if (pageSize == null) {
            return 10;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    public Integer getPageStart() {
        if (pageIndex == null || pageIndex == 0) {
            return 0;
        }
        return (pageIndex - 1) * getPageSize();
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSortField() {
        if(sortField==null){
            return "id";
        } else{
            return sortField;
        }
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getOrderType() {
        if(orderType==null){
            return "desc";
        } else{
            return orderType;
        }
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "PageEntity [pageIndex=" + pageIndex + ", pageSize=" + pageSize
                + ", pageStart=" + pageStart + ", all=" + all + ", startDate="
                + startDate + ", endDate=" + endDate + ", sortField="
                + sortField + ", orderType=" + orderType + "]";
    }
}