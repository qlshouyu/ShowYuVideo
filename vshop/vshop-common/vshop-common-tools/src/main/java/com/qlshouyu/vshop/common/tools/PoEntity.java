package com.qlshouyu.vshop.common.tools;

import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @author 高露 微信：18956074544
 * @Description 数据库对象
 * @date 19-5-29上午8:40
 */
public abstract class PoEntity extends Entity {
    private Long createTime;

    private Long updateTime;

    public void perInster(){
        if(StringUtils.isEmpty(this.getId())){
            this.setId(UUID.randomUUID().toString());
        }
        if(createTime==null){
            createTime=System.currentTimeMillis();
            updateTime=System.currentTimeMillis();
        }
    }
    public void perUpdate(){
        updateTime=System.currentTimeMillis();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
