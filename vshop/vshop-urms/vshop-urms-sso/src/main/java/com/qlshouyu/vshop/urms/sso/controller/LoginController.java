package com.qlshouyu.vshop.urms.sso.controller;

import com.qlshouyu.vshop.common.tools.ResponseResult;
import com.qlshouyu.vshop.common.web.BaseController;
import com.qlshouyu.vshop.urms.sso.service.LoginServie;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录
 *
 * @author 高露
 * 邮箱：<a href="egojit@qq.com">egojit@qq.com</a>
 * 微信：<a href="egojit">egojit</a>
 * @since 2019-6-20
 */
@RestController
@RequestMapping("/web/api/v1/sso")
@Api(value = "登录管理", tags = "登录管理")
public class LoginController extends BaseController {

    @Autowired
    private LoginServie loginServie;

    @PostMapping("/login")
    @ApiOperation("登录")
    public ResponseResult login(@RequestParam String username, @RequestParam String password) {
        return loginServie.login(username,password);
    }

    @PostMapping("/loginout")
    @ApiOperation("退出登录")
    public ResponseResult loginOut() {

        return new ResponseResult("退出成功");
    }
}
