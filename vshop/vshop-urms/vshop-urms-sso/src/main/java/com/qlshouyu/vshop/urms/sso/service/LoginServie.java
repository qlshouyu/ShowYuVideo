package com.qlshouyu.vshop.urms.sso.service;
import com.qlshouyu.vshop.common.tools.ResponseResult;
import com.qlshouyu.vshop.common.tools.utils.DigestUtils;
import com.qlshouyu.vshop.urms.model.po.Account;
import com.qlshouyu.vshop.urms.model.vo.LoginUserVo;
import com.qlshouyu.vshop.urms.service.AccountService;
import com.qlshouyu.vshop.urms.sso.jwt.JWTUtil;
import com.sun.xml.internal.bind.v2.TODO;
import org.apache.shiro.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author 高露
 * 邮箱：<a href="egojit@qq.com">egojit@qq.com</a>
 * 微信：<a href="egojit">egojit</a>
 * @since 19-6-21下午1:40
 */
@Service
public class LoginServie {
    @Autowired
    private Cache cache;
    @Autowired
    private AccountService accountService;

    /**
     * 登录
     * @param loginName　登录名
     * @param pwd　密码
     * @return　登录结果
     */
    public ResponseResult login(String loginName, String pwd) {
        String ecPwd = DigestUtils.md5DigestAsHex(pwd);
        LoginUserVo loginUser = getUser(loginName);
        if (loginUser != null) {
            if(loginUser.getPassword().equals(ecPwd)){
                String token = JWTUtil.sign(loginUser.getLoginName(), loginUser.getPassword());
                loginUser.setToken(token);
                cache.put(loginName, loginUser);
                return new ResponseResult(loginUser);
            }else{
                return new ResponseResult(new Throwable("密码不正确"));
            }
        } else {
            return new ResponseResult(new Throwable("该用户不存在"));
        }
    }

    /**
     * 登录
     * @param loginName　登录名
     * @return　登录结果
     */
    public ResponseResult loginOut(String loginName) {
        //TODO 后期实现
        return null;
    }

    /**
     * 从缓存或者数据库获取用户
     * @param loginName　登录名
     * @return　用户
     */
    public LoginUserVo getUser(String loginName) {
        LoginUserVo loginUser = getCacheUser(loginName);
        if (loginUser == null) {
            Account account = accountService.getUser(loginName);
            loginUser = account.transTo(LoginUserVo.class);
        }
        return loginUser;
    }

    /**
     * 获取缓存用户
     *
     * @param loginName　登录名
     * @return　LoginUserVo　用户
     */
    public LoginUserVo getCacheUser(String loginName) {
        Object user = cache.get(loginName);
        if (user != null) {
            return (LoginUserVo) user;
        } else {
            return null;
        }
    }
}
