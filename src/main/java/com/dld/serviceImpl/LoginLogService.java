package com.dld.serviceImpl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dld.dao.LoginLogMapper;
import com.dld.dao.UserMapper;
import com.dld.entity.LoginLog;
import com.dld.entity.User;
import com.dld.service.ILoginLogService;
import com.dld.utils.AddressUtils;


@Service
public class LoginLogService implements ILoginLogService {
	@Autowired
	private LoginLogMapper loginLogDao;
	@Autowired
	private UserMapper userDao;
	@Override
	public void addLoginLog(String name,HttpServletRequest request) {
		// TODO Auto-generated method stub
		User user = userDao.findByName(name);
		LoginLog loginfo = new LoginLog();
		loginfo.setCreatetime(new Date());
		try {
			loginfo.setLocation(AddressUtils.getAddresses("ip="+AddressUtils.getIpAddr(request), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginfo.setIp(AddressUtils.getIpAddr(request));
		loginfo.setUser(user);
		loginLogDao.addLoginLog(loginfo);
	}
	
	@Override
	public int count() {
		System.out.print("hhhhhhh");
		System.out.println("LoginLogService.count");
		// TODO Auto-generated method stub
		return loginLogDao.count();
		
	}

	@Override
	public List<LoginLog> findByPage(int page,int size) {
	
		int index;//分页查询索引
		//根据页码计算分页查询时的开始索引
		index = (page - 1) * size;
		Map<String, Object> info = new HashMap<>();
		info.put("index", index);
		info.put("size", size);
		List<LoginLog> logList;
		try {
			logList = loginLogDao.findLoginLog(info);
			return logList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
