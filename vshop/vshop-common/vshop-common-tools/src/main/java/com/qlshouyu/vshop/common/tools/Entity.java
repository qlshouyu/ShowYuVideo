package com.qlshouyu.vshop.common.tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import java.io.Serializable;

/**
 * @author 高露 微信：18956074544
 * @Description TODO
 * @date 2019-05-26 11:44
 */
public abstract class Entity implements Serializable {

    protected static Logger LOGGER= LoggerFactory.getLogger(Entity.class);

    private String id;


    public <T extends Entity> T transTo(Class<T> tClass){
        try {
            T vo = tClass.newInstance();
            BeanUtils.copyProperties(this, vo);
            return vo;
        }catch (Exception ex){
            LOGGER.error("对象转换出错",ex);
        }
        return null;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
