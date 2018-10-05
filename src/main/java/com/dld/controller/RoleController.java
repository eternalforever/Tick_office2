package com.dld.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dld.entity.Authority;
import com.dld.entity.Role;
import com.dld.service.IRoleService;
import com.dld.utils.JsonUtils;
import com.dld.vo.JsonBean;

@Controller
public class RoleController {
	@Autowired
	private IRoleService roleService;
	@RequestMapping("/allRole")
	@ResponseBody
	public Map<String,Object> allRoles(Integer page,Integer limit) {
		Map<String,Object> info = new HashMap<>();
		if(page==null) {
			List<Role> list = roleService.AllRoleAuthority(0, 0);
			info.put("data", list);
			return info;
		}
		try {
			List<Role> list = roleService.AllRoleAuthority(page, limit);
			info.put("code", 0);
			info.put("count", roleService.roleCount());
			info.put("msg", "");
			info.put("data", list);
			return info;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("/roleAuthority")
	@ResponseBody
	public List<Authority> findroleAuthority() {
		try {
			List<Authority> list = roleService.findRoleAuthority();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}
	@RequestMapping("/roleAuthEdite")
	@ResponseBody
	public JsonBean updateRoleAuthority(int id,@RequestParam("rids")String[] rids) {
		if(rids == null) {
			return JsonUtils.writeJsonUtils(1, null);
		}
		
		List<Integer> ids = new ArrayList<Integer>();
		for (String string : rids) {
						
		 ids.add(Integer.parseInt(string));
			
		}
		try {
			roleService.updateRoleAuthority(id, ids);
			return JsonUtils.writeJsonUtils(1, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return JsonUtils.writeJsonUtils(0, e.getMessage());
		}
	
	}
}
