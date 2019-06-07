package com.qlshouyu.vshop.urms.service;
import com.qlshouyu.vshop.common.ResponseResult;
import com.qlshouyu.vshop.common.database.BaseService;
import com.qlshouyu.vshop.urms.model.po.Dictionary;
import com.qlshouyu.vshop.urms.model.vo.DictionarySearchVo;
import com.qlshouyu.vshop.urms.model.vo.DictionaryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 字典服务对象 {@code Dictionary}
 * @author 高露 邮箱：<a href="egojit@qq.com">egojit@qq.com</a>
 * @since 19-5-28上午10:55
 */
@Service
public class DictionaryService extends BaseService<Dictionary> {

    /**
     * 根据条件查询所有字典
     * @param search 搜索条件{@code DictionarySearchVo}
     * @return 字典{@code Dictionary}列表
     */
    public ResponseResult<List<Dictionary>> list(DictionarySearchVo search) {
        Example example=new Example(Dictionary.class);
        Example.Criteria criteria= example.createCriteria();
        if(!StringUtils.isEmpty(search.getName())){
            criteria.andLike("name",search.getName());
        }
        if(!StringUtils.isEmpty(search.getValue())){
            criteria.andEqualTo("value",search.getValue());
        }
        if(!StringUtils.isEmpty(search.getParentId())){
            criteria.andEqualTo("parentId",search.getParentId());
        }
        return this.listByExemple(example);
    }

    /**
     * 修改
     * @param model 字典详情界面对象{@code DictionaryVo}
     * @return 字典对象 {@code Dictionary}
     */
    public ResponseResult<Dictionary> edit(DictionaryVo model) {
        Dictionary dic= model.transTo(Dictionary.class);
        return this.editSelective(dic);
    }

}
