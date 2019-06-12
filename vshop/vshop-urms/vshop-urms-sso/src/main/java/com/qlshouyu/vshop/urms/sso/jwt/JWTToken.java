package com.qlshouyu.vshop.urms.sso.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author 高露 微信：18956074544
 * @Description TODO
 * @date 19-6-12下午12:51
 */
public class JWTToken implements AuthenticationToken {

    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
