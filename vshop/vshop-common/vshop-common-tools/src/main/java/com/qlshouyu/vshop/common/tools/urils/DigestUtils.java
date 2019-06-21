package com.qlshouyu.vshop.common.tools.urils;

/**
 * TODO
 *
 * @author 高露 邮箱：<a href="egojit@qq.com">egojit@qq.com</a>
 * @since 2019-06-15 08:51
 */
public class DigestUtils extends org.springframework.util.DigestUtils {

    /**
     * md5加密
     * @param str
     * @return
     */
    public static String md5DigestAsHex(String str){
        String result= md5DigestAsHex(str.getBytes());
        return result;
    }

}
