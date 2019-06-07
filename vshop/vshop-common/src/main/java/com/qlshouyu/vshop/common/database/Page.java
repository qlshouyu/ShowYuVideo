package com.qlshouyu.vshop.common.database;

import java.util.List;

/**
 * @author 高露 微信：18956074544
 * @Description 分页信息
 * @date 19-5-28下午2:41
 */
public class Page<T extends Entity> {
    private int count;

    private int pageNum;

    private int pageSize;

    private List<T> content;

    public Page(int pageNum,int pageSize){
        this.pageNum=pageNum;
        this.pageSize=pageSize;
    }
    public Page(){
        this(1,10);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
