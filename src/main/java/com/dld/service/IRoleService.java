package com.dld.service;

import java.util.List;
import java.util.Map;

import com.dld.entity.Authority;
import com.dld.entity.Role;

public interface IRoleService {
	List<Role> AllRoleAuthority(int page,int limit);
	public void updateUserRole(Map<String,Object> info);
	public int roleCount();
	 List<Authority> findRoleAuthority();
	 public void updateRoleAuthority(int rid,List<Integer> aids);
}
