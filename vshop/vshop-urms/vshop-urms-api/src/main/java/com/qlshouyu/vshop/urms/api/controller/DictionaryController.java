package com.qlshouyu.vshop.urms.api.controller;

import com.qlshouyu.vshop.common.tools.ResponseResult;
import com.qlshouyu.vshop.common.web.BaseController;
import com.qlshouyu.vshop.urms.model.po.Dictionary;
import com.qlshouyu.vshop.urms.model.vo.DictionarySearchVo;
import com.qlshouyu.vshop.urms.model.vo.DictionaryVo;
import com.qlshouyu.vshop.urms.service.DictionaryService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 字典管理
 * @author 高露 邮箱：<a href="egojit@qq.com">egojit@qq.com</a>
 * @since 19-5-28上午10:55
 */
@RestController
@RequestMapping("/api/admin/v1/dictionary")
@Api(value = "字典管理",tags = "字典管理")
public class DictionaryController extends BaseController {

    @Autowired
    private DictionaryService service;

    /**
     * 根据条件查询所有字典
     * @param search 查询条件 {@code DictionarySearchVo}
     * @return 返回字典列表 {@code List<Dictionary>}
     */
    @GetMapping
    @ApiOperation(value = "字典-列表")
    public ResponseResult<List<Dictionary>> list(@ApiParam(value = "查询参数") DictionarySearchVo search) {
        return service.list(search);
    }


    @PostMapping
    @ApiOperation(value = "字典-编辑[添加/修改]")
    public ResponseResult<Dictionary> edit(@ApiParam(value = "字典对象",required = true) DictionaryVo model) {
        return service.edit(model);
    }

    /**
     * 根据多个id删除字典
     *
     * @param ids 多个id逗号隔开{@code String}
     * @return 实体对象
     */
    @DeleteMapping("/{ids}")
    @ApiOperation(value = "字典-删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name="ids", value="逗号隔开的多个字典id", required=true, paramType="path", dataType="String")
    })
    public ResponseResult<Dictionary> delete(@PathVariable(value = "ids",required = true) String ids) {
        return service.delete(ids);
    }
}
