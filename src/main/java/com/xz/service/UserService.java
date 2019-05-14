package com.xz.service;

import com.xz.entity.User;

public interface UserService {
    void addUser(String username,String password,String realname);

    User queryByUserName(String username);
}
