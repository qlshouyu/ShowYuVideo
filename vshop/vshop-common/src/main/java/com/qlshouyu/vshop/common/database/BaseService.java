package com.qlshouyu.vshop.common.database;

import com.github.pagehelper.PageHelper;
import com.qlshouyu.vshop.common.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * 基础服务类，所有服务类继承此类；此类是一个泛型类，只有 {@code PoEntity}也就是
 * 数据库对象作为此类的泛型
 *
 * @author 高露 邮箱：<a href="egojit@qq.com">egojit@qq.com</a>
 * @since 19-5-28上午10:55
 */
public abstract class BaseService<P extends PoEntity> {

    private final static Logger LOGGER = LoggerFactory.getLogger(BaseService.class);

    @Autowired
    protected Mapper<P> mapper;

    /**
     * 编辑和修改
     *
     * @param model 实体对象
     * @return 实体对象
     */
    public ResponseResult<P> editSelective(P model) {
        if (StringUtils.isEmpty(model.getId())) {
            model.perInster();
            this.mapper.insert(model);
        } else {
            model.perUpdate();
            this.mapper.updateByPrimaryKeySelective(model);
        }
        return new ResponseResult<>(model);
    }

    /**
     * 删除
     *
     * @param ids 多个id逗号隔开{@code String}
     * @return 实体对象
     */
    public ResponseResult<P> delete(String ids) {
        Assert.notNull(ids, "ids is required");
        String[] idList = ids.split(",");
        return this.delete(ids);
    }

    /**
     * 字典删除
     * @param ids id list {@code List<String> ids}
     * @return 删除结果
     */
    public ResponseResult<String> delete(List<String> ids) {
        Assert.notNull(ids, "id list can not be null");
        int count=0;
        for (String id : ids) {
            count+=this.mapper.deleteByPrimaryKey(id);
        }
        if(count>0) {
            return new ResponseResult<>("删除成功");
        }else {
            return new ResponseResult<>(new Throwable("删除失败"));
        }
    }


    /**
     * 分页获取列表
     *
     * @param page    分页信息
     * @param example 查询条件
     * @return 结果
     */
    public ResponseResult<Page<P>> pageByExemple(Page<P> page, Example example) {
        if (StringUtils.isEmpty(example.getOrderByClause())) {
            example.setOrderByClause("create_time desc");
        }
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<P> list = mapper.selectByExample(example);
        int count = mapper.selectCountByExample(example);
        page.setCount(count);
        page.setContent(list);
        return new ResponseResult<>(page);
    }

    protected <T extends Entity> List<T> transTo(List list, Class<T> to) {
        List<T> results = new ArrayList<>();
        if (list != null) {
            for (Object o : list) {
                try {
                    T t = to.newInstance();
                    BeanUtils.copyProperties(o, t);
                    results.add(t);
                } catch (Exception e) {
                    LOGGER.error("copyProperties error:", e);
                }
            }
        }
        return results;
    }

    /**
     * 分页获取列表
     *
     * @param example 查询条件
     * @return 查询结果
     */
    public ResponseResult<List<P>> listByExemple(Example example) {
        if (StringUtils.isEmpty(example.getOrderByClause())) {
            example.setOrderByClause("create_time desc");
        }
        List<P> list = mapper.selectByExample(example);
        return new ResponseResult<>(list);
    }

    /**
     * 获取对象
     *
     * @return 对象结果
     */
    protected ResponseResult<P> getById(P model) {
        model = mapper.selectOne(model);
        return new ResponseResult<>(model);
    }


}
