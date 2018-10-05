package com.dld.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dld.entity.Authority;
import com.dld.entity.Role;
import com.dld.entity.User;
import com.dld.service.IAuthorityService;
import com.dld.utils.JsonUtils;
import com.dld.vo.JsonBean;


@Controller
public class AuthorityController {

	@Autowired
	private IAuthorityService authorityService;

	@RequestMapping("/findMenu")
	@ResponseBody
	public List<Authority> menus(){
		 User user= (User) SecurityUtils.getSubject().getSession().getAttribute("user");

		List<Authority> menu = authorityService.menu(user.getId());

		return menu;

	}

	@RequestMapping("/authoritylist")
	@ResponseBody
	public Map<String,Object> findAllPermit(int page,int limit){
		Map<String,Object> data = new HashMap<>();

		List<Authority> list = authorityService.findAllPermits(page, limit);
		data.put("count", authorityService.count());
		data.put("data",list);
		data.put("msg","");
		data.put("code",0);

		return data;

	}
	@RequestMapping("/authorityDelete")
	@ResponseBody
	public JsonBean deleteAuthority(int id){
		try {
			authorityService.deleteById(id);
			return JsonUtils.writeJsonUtils(1, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return JsonUtils.writeJsonUtils(0, e.getMessage());
		}

	}

	@RequestMapping("/addauthority")
	@ResponseBody
	public JsonBean addPermit(Authority authority) {

		try {
			if(authority.getParentid() == null) {
				authority.setParentid(0);
			}
			authorityService.addAuthority(authority);
			return JsonUtils.writeJsonUtils(1, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return JsonUtils.writeJsonUtils(0, e.getMessage());
		}
	}

	@RequestMapping("updateAuthority")
	@ResponseBody
	public JsonBean updateAuthority(Authority authority) {
		try {
			 authorityService.updateAuthority(authority);
			return JsonUtils.writeJsonUtils(1, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return JsonUtils.writeJsonUtils(1, e.getMessage());
		}

	}


}

