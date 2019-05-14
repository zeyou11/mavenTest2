package com.xz.dao;

import com.xz.entity.User;
import org.apache.commons.logging.Log;
import org.apache.cxf.common.logging.LogUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class UserMapperTest {
    private ApplicationContext applicationContext;
    @Autowired
    private UserMapper userMapper;
    @Test
    public void insert() {
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        user.setRealname("张三");
        userMapper.insert(user);

    }

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");//加载spring配置文件
        userMapper = applicationContext.getBean(UserMapper.class);//在这里导入要测试的
    }

    @After
    public void tearDown() throws Exception {
    }

}