package com.qlshouyu.vshop.urms.sso.controller;

import com.qlshouyu.vshop.common.tools.RESPONSE_STATUS;
import com.qlshouyu.vshop.common.tools.ResponseResult;
import com.qlshouyu.vshop.common.tools.utils.DigestUtils;
import com.qlshouyu.vshop.urms.model.po.Dictionary;
import com.qlshouyu.vshop.urms.model.vo.DictionaryVo;
import com.qlshouyu.vshop.urms.service.DictionaryService;
import com.qlshouyu.vshop.urms.sso.UrmsSsoApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 *
 * @author 高露
 * 邮箱：<a href="egojit@qq.com">egojit@qq.com</a>
 * 微信：<a href="egojit">egojit</a>
 * @since 19-6-21下午2:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UrmsSsoApplication.class)
public class LoginControllerTest {
    @Autowired
    private LoginController loginController;
    @Test
    public void contextLoads() {
    }
    @Test
    public void login() {
       ResponseResult responseResult= loginController.login("admin", DigestUtils.md5DigestAsHex("admin"));
       Assert.assertEquals(responseResult.getCode(), RESPONSE_STATUS.SUCCESS);
    }
//    @Autowired
//    private DictionaryService service;
//
//
//    @Test
//    public void save(){
//        DictionaryVo dictionary=new DictionaryVo();
//        dictionary.setName("测试");
//        dictionary.setValue("test");
//        ResponseResult<Dictionary> dist = service.edit(dictionary);
//        Assert.assertNotNull(dist);
//    }

}
