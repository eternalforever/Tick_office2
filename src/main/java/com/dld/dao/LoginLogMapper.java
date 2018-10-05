package com.dld.dao;

import java.util.List;
import java.util.Map;

import com.dld.entity.LoginLog;

public interface LoginLogMapper{
	public int count();
	public List<LoginLog> findLoginLog(Map<String,Object> info);
	public void addLoginLog(LoginLog log);
	
}