package com.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.UserMapper;
import com.user.pojo.User;
import com.user.service.IUserService;

@Service("iUserService")
public class UserServiceImpl implements IUserService{

	@Autowired
	UserMapper userMapper;
	
	
	public int add(User user) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(user);
	}

	public int update(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(user);
	}

	public int delete(String id) {
		// TODO Auto-generated method stub
		return userMapper.delete(id);
	}

	public List<User> getUsers(User user) {
		// TODO Auto-generated method stub
		return userMapper.selectByExample(user);
	}

}
