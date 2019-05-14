package com.xz.dao;

import com.xz.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByUserName(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}