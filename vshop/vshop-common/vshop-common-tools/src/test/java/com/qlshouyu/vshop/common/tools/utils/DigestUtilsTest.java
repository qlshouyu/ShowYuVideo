package com.qlshouyu.vshop.common.tools.utils;


import org.junit.Assert;

/**
 * TODO
 *
 * @author 高露
 * 邮箱：<a href="egojit@qq.com">egojit@qq.com</a>
 * 微信：<a href="egojit">egojit</a>
 * @since 19-6-21下午2:30
 */
public class DigestUtilsTest {

    @org.junit.Test
    public void md5DigestAsHex() {
        String pwd= DigestUtils.md5DigestAsHex("123456");
        Assert.assertNotNull(pwd);
    }
}
