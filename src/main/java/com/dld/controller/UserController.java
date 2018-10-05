package com.dld.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.dld.entity.LoginLog;
import com.dld.entity.Role;
import com.dld.entity.User;
import com.dld.service.ILoginLogService;
import com.dld.service.IUserService;
import com.dld.utils.JsonUtils;
import com.dld.vo.JsonBean;

@Controller
public class UserController {
	@Autowired
	private IUserService userService;
	@Autowired
	private ILoginLogService loginLogService;

	@RequestMapping("/login.do")
	@ResponseBody
	public JsonBean login(String username, String password, HttpServletRequest request) {
		User user = userService.query(username);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			 Session session = subject.getSession();
	         session.setAttribute("user",user );
			loginLogService.addLoginLog(username, request);
			return JsonUtils.writeJsonUtils(1, null);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return JsonUtils.writeJsonUtils(0, null);
		}

	}

	@RequestMapping("/logout.do")
	public String loginOut(HttpServletRequest request) {

		HttpSession session = request.getSession();
		session.removeAttribute("username");
		;
		return "redirect:/login.html";

	}

	@RequestMapping("/register.do")
	public String register(User user, HttpServletRequest request) {

		userService.register(user);

		return "redirect:/login.html";

	}

	@RequestMapping("/ListLoginLog")
	@ResponseBody
	public Map<String, Object> findAll(int page, int limit) {
		Map<String, Object> map = new HashMap<>();
		List<LoginLog> list = loginLogService.findByPage(page, limit);
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", loginLogService.count());
		map.put("data", list);

		return map;

	}
	@RequestMapping("/findAllUser")
	@ResponseBody
	public Map<String,Object> findAllRole(int page,int limit) {
		Map<String,Object> map = new HashMap<>();
		try {
			List<User> list = userService.findAllRole(page,limit);
			map.put("code", 0);// 针对layui的表格，0表示成功
			map.put("msg", "");
			map.put("count", userService.count());
			map.put("data",list);
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("/queryUser")
	@ResponseBody
	public Map<String,Object> findAllRole(String no,int flag) {
		Map<String,Object> map = new HashMap<>();
		try {
			User user = userService.findUserRole(no,flag);
			map.put("code", 0);// 针对layui的表格，0表示成功
			map.put("msg", "");
			
			map.put("data",user);
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/updaeUserRole")
	@ResponseBody
	public JsonBean updateRole() {
		
		return null;
	}
	
	

}
