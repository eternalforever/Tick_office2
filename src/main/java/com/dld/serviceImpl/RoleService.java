package com.dld.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dld.dao.AuthorityMapper;
import com.dld.dao.RoleMapper;
import com.dld.entity.Authority;
import com.dld.entity.Role;
import com.dld.service.IRoleService;
@Service
public class RoleService implements IRoleService {
	@Autowired
	private RoleMapper roleDao;
	@Autowired
	private AuthorityMapper authorityDao;
	@Override
	public List<Role> AllRoleAuthority(int page, int limit) {
		Map<String, Object> info = new HashMap<>();
		if(page==0) {
			
			info.put("index", 0);
			info.put("size", 0);
			List<Role> roles = roleDao.findRoles(info);
			return roles;
		}
		int index;//分页查询索引
		//根据页码计算分页查询时的开始索引
		index = (page - 1) * limit;
		
		info.put("index", index);
		info.put("size", limit);
		try {
			List<Role> roles = roleDao.findRoles(info);
			return roles;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateUserRole(Map<String, Object> info) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int roleCount() {
		// TODO Auto-generated method stub
		return roleDao.count();
	}

	@Override
	public List<Authority> findRoleAuthority() {
		// TODO Auto-generated method stub
		List<Authority> list = authorityDao.allAuthority();
		return list;
	}

	@Override
	public void updateRoleAuthority(int rid, List<Integer> aids) {
		// TODO Auto-generated method stub
		Map<String,Object> info = new HashMap<>();
		info.put("rid", rid);
		List<Integer> aids2 = roleDao.aids(rid);
		
		for (Integer aid : aids) {
			if(!aids2.contains(aid)) {
				
				info.put("aid", aid);
				roleDao.addRoleAuthority(info);
			}else {
				for (Integer aid2 : aids2) {
					if(!aids.contains(aid2)) {
						info.put("aid", aid2);
						roleDao.deleteRoleAuthority(info);
					}
				}
			}
			
		}
	}

}
