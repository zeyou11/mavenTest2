package com.xz.service.impl;

import com.xz.dao.UserMapper;
import com.xz.entity.User;
import com.xz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public void addUser(String username, String password, String realname) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRealname(realname);
        userMapper.insert(user);
    }

    public User queryByUserName(String username) {
        return userMapper.selectByUserName(username);
    }
}
