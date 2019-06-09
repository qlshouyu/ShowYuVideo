package com.qlshouyu.vshop.urms.model.po;

import com.qlshouyu.vshop.common.tools.PoEntity;

import javax.persistence.Table;

/**
 * @author 高露 微信：18956074544
 * @Description TODO
 * @date 2019-05-26 11:38
 */
@Table(name = "urms_dictionary")
public class Dictionary extends PoEntity {

    /**
     * 名称
     */
    private String name;
    /**
     * 字典值
     */
    private String value;

    /**
     * 父id
     */
    private String parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
