package com.qlshouyu.vshop.urms.model.vo;
import com.qlshouyu.vshop.common.tools.VoEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author 高露 微信：18956074544
 * @Description TODO
 * @date 2019-06-07 12:32
 */
@ApiModel(value = "com.qlshouyu.vshop.urms.model.vo.DictionaryVo", description = "字典详情")
public class DictionaryVo extends VoEntity {
    /**
     * 名称
     */
    @ApiModelProperty(value = "字典名称",required = true)
    @NotNull(message = "字典名称不能为空")
    private String name;
    /**
     * 字典值
     */
    @ApiModelProperty(value = "字典值",required = true)
    @NotNull(message = "字典值不能为空")
    private String value;

    /**
     * 父id
     */
    @ApiModelProperty(value = "父字典id",required = false)
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
