package com.xz.controller;

import com.xz.entity.User;
import com.xz.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public ModelAndView addUser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("realname") String realname) {
        userService.addUser(username, password, realname);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/add_success");
        mav.addObject("");
        return mav;
    }

    @RequestMapping("/queryByUserName")
    @ResponseBody
    public Map<String, Object> queryByUserName(@RequestParam("username") String username) {
        User user = userService.queryByUserName(username);
        System.out.println(user);
        // 记录日志
        logger.info("This is info message.");
        logger.error("This is error message.");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("obj1", "999");
        map.put("user", user);
        return map;
    }
}
