package com.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.user.pojo.User;

public interface UserMapper {

    int insertSelective(User user);

    List<User> selectByExample(User user);

    int updateByPrimaryKeySelective(User user);
    
    int delete(@Param("id") String id);

}