package com.dld.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.dld.dao.LoginLogMapper;
import com.dld.dao.RoleMapper;
import com.dld.dao.UserMapper;
import com.dld.entity.LoginLog;
import com.dld.entity.Role;
import com.dld.entity.User;

import com.dld.service.IUserService;
import com.dld.utils.AddressUtils;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserMapper userDao;
	@Autowired
	private LoginLogMapper loginLogDao;
	
	@Override
	public void login(String name, String password) {
		
		if(StringUtils.isEmpty(name)) {
			throw new RuntimeException("用户名不能为空");
		};
		if(StringUtils.isEmpty(password)) {
			throw new RuntimeException("密码不能为空");
		};
		User user = null;
		try {
			user = userDao.findByName(name);
		} catch (Exception e) {
			throw e;
		}
		if (null == user) {
			throw new RuntimeException("输入用户名错误");
			
		}
		if(!user.getPassword().equals(password)) {
			
			throw new RuntimeException("输入密码错误");
		}
		
	}
	@Override
	public void register(User user) {
		
		if(user == null) {
			throw new RuntimeException("用户数据补鞥为空");
		}
		if(StringUtils.isEmpty(user.getName())) {
			throw new RuntimeException("用户名数据补鞥为空");
		}
		if(StringUtils.isEmpty(user.getPassword())) {
			throw new RuntimeException("用户密码数据补鞥为空");
		}
		
		if(userDao.findByName(user.getName()) !=null) {
			throw new RuntimeException("用户已存在");
		}
		try {
			userDao.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	
	}
	/**
	 * @method 查找所有用户的权限
	 */
	@Override
	public List<User> findAllRole(int page,int limit) {
		int index;//分页查询索引
		//根据页码计算分页查询时的开始索引
		index = (page - 1) * limit;
		Map<String, Object> info = new HashMap<>();
		info.put("index", index);
		info.put("size", limit);
		try {
			List<User> list = userDao.findAllRole(info);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查找角色权限
	 * @return
	 */
	@Override
	public User findUserRole(String no,Integer flag) {
		Map<String,Object> info = new HashMap<>();
		try {
			if(no != null && flag !=null) {
				info.put("no", no);
				info.put("flag", flag);
			}else if(flag == null) {
				info.put("no", no);
			}else if(no == null) {
				info.put("no", no);
			}else {
				throw new RuntimeException("请输入正确参数");
			}
			User user = userDao.findUserRole(info);
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return userDao.count();
		
	}
	@Override
	public User query(String username) {
		User user = userDao.findByName(username);
		return user;
	}
	
	

}
