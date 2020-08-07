package com.xss.libraryfinal.global;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Scope("prototype")
public class PageBean<T> {
    //当前页
    private int currentPage;
    //当前条数
    private int currentCount;
    //总页数
    private int totalPage;
    //总数据条数
    private int totalCount;
    //当前数据
    private List<T> beans;

    public PageBean(){}

    public PageBean(int currentPage, int currentCount, int totalPage, int totalCount, List<T> beans) {
        this.currentPage = currentPage;
        this.currentCount = currentCount;
        this.totalPage =totalPage;
        this.totalCount = totalCount;
        this.beans = beans;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalCount % currentCount == 0 ? totalCount / currentCount : totalCount / currentCount + 1;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getBeans() {
        return beans;
    }

    public void setBeans(List<T> beans) {
        this.beans = beans;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", currentCount=" + currentCount +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", beans=" + beans +
                '}';
    }
}
