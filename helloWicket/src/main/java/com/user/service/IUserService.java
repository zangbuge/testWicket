package com.user.service;

import java.util.List;

import com.user.pojo.User;

public interface IUserService {
	
	int add(User user);
	
	int update(User user);
	
	int delete(String id);
	
	List<User> getUsers(User user);

}
