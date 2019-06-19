package com.qlshouyu.vshop.urms.sso.controller;

import com.qlshouyu.vshop.common.tools.ResponseResult;
import com.qlshouyu.vshop.common.web.BaseController;
import com.qlshouyu.vshop.urms.sso.jwt.JWTUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.security.pkcs11.wrapper.Constants;

/**
 * @author 高露 微信：18956074544
 * @Description TODO
 * @date 19-6-12下午1:42
 */
@RestController
@Api(value = "登录管理",tags = "登录管理")
public class LoginController extends BaseController {

    @PostMapping("/login")
    @ApiOperation("登录")
    public ResponseResult login(@RequestParam String username, @RequestParam String password) {
//        JWTUtil.sign()
        return null;
    }

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    public String jwtLogin(String username, String password) {
        Assert.notNull(username, "用户名不能为空");
        Assert.notNull(password, "密码不能为空");

//        // 获取用户密码混淆值
//        MemberDTO member = memberService.getMemberSalt(username);
//
//        // 加密当前用户输入密码
        byte[] bytePassword = DigestUtil.sha1(password.getBytes(), EncodeUtils.hexDecode(member.getSalt()), Constants.PASSWORD_HASH_INTERATIONS);
//        String encodePassword = EncodeUtils.hexEncode(bytePassword);
//
//        if (!encodePassword.equals(member.getLoginPassword())) {
//            throw new TSharkException("900");
//        }

        return JWTUtil.sign(username, encodePassword);
    }
}
