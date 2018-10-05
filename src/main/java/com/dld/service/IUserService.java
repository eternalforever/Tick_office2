package com.dld.service;


import java.util.List;
import java.util.Map;

import com.dld.entity.Role;
import com.dld.entity.User;

public interface IUserService {
	public void register(User user);
	public void login(String username,String password);
	public List<User> findAllRole(int page,int limit);
	public User findUserRole(String no,Integer flag);
	public int count();
	public User query(String username);
	
	
}
