package com.qlshouyu.vshop.urms.service;

import com.qlshouyu.vshop.common.database.BaseService;
import com.qlshouyu.vshop.common.tools.ResponseResult;
import com.qlshouyu.vshop.urms.model.po.Account;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * 账户服务
 *
 * @author 高露 邮箱：<a href="egojit@qq.com">egojit@qq.com</a>
 * @since 2019-06-12 21:32
 */
@Service
public class AccountService extends BaseService<Account> {

    /**
     * 通过用户名和密码获取用户
     * @param loginName
     * @param pwd
     * @return
     */
    public Account getUser(String loginName,String pwd) {
        Example example=new Example(Account.class);
        Example.Criteria criteria= example.createCriteria();
        criteria.andEqualTo("loginName",loginName);
        criteria.andEqualTo("password",pwd);
        Account account= mapper.selectOneByExample(example);
        return account;
    }

    /**
     * 通过用户名获取用户
     * @param loginName
     * @return
     */
    public Account getUser(String loginName) {
        Example example=new Example(Account.class);
        Example.Criteria criteria= example.createCriteria();
        criteria.andEqualTo("loginName",loginName);
        Account account= mapper.selectOneByExample(example);
        return account;
    }

    /**
     * 添加用户
     * @param account
     * @return 添加用户
     */
    public ResponseResult<Account>  addUser(Account account){
        return this.editSelective(account);
    }
}
