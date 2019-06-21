package com.qlshouyu.vshop.urms.service;

import com.qlshouyu.vshop.common.tools.RESPONSE_STATUS;
import com.qlshouyu.vshop.common.tools.ResponseResult;
import com.qlshouyu.vshop.common.tools.utils.DigestUtils;
import com.qlshouyu.vshop.urms.model.po.Account;
import org.junit.Assert;
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
 * @since 19-6-21下午2:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestRunner.class)
public class AccountServiceTest {
    @Autowired
    private AccountService service;
    @org.junit.Test
    public void save() {
        Account account=new Account();
        account.setLoginName("admin");
        account.setPassword(DigestUtils.md5DigestAsHex("admin"));
        ResponseResult<Account> accountResponseResult = service.editSelective(account);
        Assert.assertNotNull("",accountResponseResult);
        Assert.assertEquals(RESPONSE_STATUS.SUCCESS,accountResponseResult.getStatus());
    }

}
