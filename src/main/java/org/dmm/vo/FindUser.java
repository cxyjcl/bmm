package org.dmm.vo;

/**
 * Created by Administrator on 2018/1/25 0025.
 */
public class FindUser {

    private String realName;

    private Integer pageIndex;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    @Override
    public String toString() {
        return "FindUser{" +
                "realName='" + realName + '\'' +
                ", pageIndex='" + pageIndex + '\'' +
                '}';
    }
}
