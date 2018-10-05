package com.dld.dao;

import java.util.List;
import java.util.Map;

import com.dld.entity.Role;

public interface RoleMapper {
   
	void addRole(Role role);
    Role findByRoleId(Integer id);
    List<Role> findRoles(Map<String,Object> info);
    int count();
    public void deleteRoleAuthority(Map<String,Object> info);
    public void addRoleAuthority(Map<String,Object> info);
    List<Integer> aids(Integer rid);

    
}