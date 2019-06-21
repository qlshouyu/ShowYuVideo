package com.qlshouyu.vshop.urms.sso;

import com.qlshouyu.vshop.urms.model.vo.LoginUserVo;
import com.qlshouyu.vshop.urms.sso.jwt.JWTToken;
import com.qlshouyu.vshop.urms.sso.jwt.JWTUtil;
import com.qlshouyu.vshop.urms.sso.service.LoginServie;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author 高露 邮箱：<a href="egojit@qq.com">egojit@qq.com</a>
 * @since 2019-06-09 17:02
 */
public class MyShiroRealm  extends AuthorizingRealm{
    private static final Logger LOGGER = LoggerFactory.getLogger(MyShiroRealm.class);

    private LoginServie loginServie;

    public MyShiroRealm(LoginServie loginServie){
        this.loginServie=loginServie;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        LOGGER.info("doGetAuthorizationInfo+" + principals.toString());

        String username = JWTUtil.getUsername(principals.toString());
        LoginUserVo userVo= loginServie.getUser(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//
//        List<String> userPermissions = shiroAuthService.getPermissions(member.getId());
//
//        // 基于Permission的权限信息
//        info.addStringPermissions(userPermissions);

        return info;
    }

    /**
     * 使用JWT替代原生Token
     *
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        String token = (String) authcToken.getCredentials();

        String username = JWTUtil.getUsername(token);
        LoginUserVo userVo= loginServie.getUser(username);

        // 用户不会空
        if (userVo != null) {
            // 密码验证
            if (!JWTUtil.verify(token, username, userVo.getPassword())) {
                throw new UnknownAccountException("用户名或者密码错误");
            }
            return new SimpleAuthenticationInfo(token, token, "realm");
        } else {
            throw new UnknownAccountException("用户名或者密码错误");
        }
    }
}
