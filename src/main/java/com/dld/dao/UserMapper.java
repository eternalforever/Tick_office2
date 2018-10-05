package com.dld.dao;

import java.util.List;
import java.util.Map;

import com.dld.entity.User;

public interface UserMapper {
    void addUser(User user);
	User findByName(String name);
	public List<User> findAllRole(Map<String,Object> info);
	public User findUserRole(Map<String,Object> info);
	int count();
	public void deleteUserRole(Map<String,Object> info);
	public void addUserRole(Map<String,Object> info);
}