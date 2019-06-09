package com.qlshouyu.vshop.urms.api;

import com.qlshouyu.vshop.common.tools.ResponseResult;
import com.qlshouyu.vshop.urms.model.po.Dictionary;
import com.qlshouyu.vshop.urms.model.vo.DictionaryVo;
import com.qlshouyu.vshop.urms.service.DictionaryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UrmsAdminApiApplication.class)
public class UrmsAdminApiApplicationTests {

    @Autowired
    private DictionaryService service;

    @Test
    public void contextLoads() {
    }
    @Test
    public void save(){
        DictionaryVo dictionary=new DictionaryVo();
        dictionary.setName("测试");
        dictionary.setValue("test");
        ResponseResult<Dictionary> dist = service.edit(dictionary);
        Assert.assertNotNull(dist);
    }

}
