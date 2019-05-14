package com.xz.test;

import com.xz.dao.UserMapper;
import com.xz.entity.User;
import com.xz.util.RedisUtil;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
@SuppressWarnings("all")
public class MyTest {
    private static Logger logger = Logger.getLogger(MyTest.class);
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("zhangsan2");
        user.setPassword("1234567");
        user.setRealname("张三2");
        userMapper.insert(user);
    }
    @Test
    public void testSpringRedis() {
        String str = "hl";
        redisUtil.set("str", str);
        redisUtil.expire("str", 60);
        String redisStr = (String) redisUtil.get("str");
        System.out.print(redisStr);
        List<String> list = new ArrayList<String>();//list
        list.add("0");
        list.add("中国list");
        list.add("2");
        redisUtil.lSet("list1", list);
        redisUtil.expire("list1", 120);//指定失效时间为1分钟
        List<Object> list1 = redisUtil.lGet("list1", 0, -1);
        System.out.println(list1);
        Map<String, Object> map = new HashMap();//map
        map.put("key1", "str1");
        map.put("key2", "中国map");
        map.put("key3", "str3");
        redisUtil.hmset("map1", map);
        redisUtil.expire("map1", 120);//指定失效时间为2分钟
        Map<Object, Object> map1 = redisUtil.hmget("map1");
        System.out.println(map1);
    }
}
