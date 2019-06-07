package com.qlshouyu.vshop.urms.service;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.TestPropertySource;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 高露 微信：18956074544
 * @Description TODO
 * @date 19-5-28上午11:47
 */
@MapperScan("com.qlshouyu.vshop.urms.repository")
@SpringBootApplication(scanBasePackages = {"com.qlshouyu.vshop"})
@TestPropertySource("classpath:application.properties")
public class TestRunner {
}
