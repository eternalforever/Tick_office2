package com.dld.service;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import com.dld.entity.LoginLog;


public interface ILoginLogService {
	public void addLoginLog(String username,HttpServletRequest request);
	public int count();
	public List<LoginLog> findByPage(int page,int size);
}
