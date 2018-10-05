package com.dld.serviceImpl;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dld.dao.AuthorityMapper;
import com.dld.dao.RoleMapper;
import com.dld.dao.UserMapper;
import com.dld.entity.Authority;
import com.dld.entity.Role;
import com.dld.service.IAuthorityService;

@Service
public class AuthorityService implements IAuthorityService{
	@Autowired
	private AuthorityMapper authorityDao;
	@Autowired
	private UserMapper userDao;
	@Override
	public Set<String> findPermitByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Authority> menu(Integer id) {
		
		try {
			List<Authority> list=authorityDao.findMenu(id);
			return  list;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Authority> findAllPermits(int page,int size) {
		// TODO Auto-generated method stub
		int index;//分页查询索引
		//根据页码计算分页查询时的开始索引
		index = (page - 1) * size;
		Map<String, Object> info = new HashMap<>();
		info.put("index", index);
		info.put("size", size);
		
		List<Authority> list;
		try {
			list = authorityDao.findPermits(info);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int count() {
		return authorityDao.count();
		
	}

	@Override
	public void addAuthority(Authority authority) {
		// TODO Auto-generated method stub
		if(authority == null ) {
			throw new RuntimeException("添加数据为空");
		}else if(authorityDao.findByTitle(authority.getTitle()) != null){
			throw new RuntimeException("不能添加同名权限");
		}else {
			authorityDao.addSelective(authority);
		}
	}

	@Override
	public Authority findById(Integer id) {
		// TODO Auto-generated method stub
		Authority authority = authorityDao.findById(id);
		return authority;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		if (authorityDao.findByParent(id).size() == 0) {
			authorityDao.deleteById(id);
		}else {
			throw new RuntimeException("请先删除该权限下的子权限");
		}
		
		
	}

	@Override
	public void updateAuthority(Authority authority) {
		// TODO Auto-generated method stub
		authorityDao.updateAuthority(authority);
	}

	@Override
	public List<Authority> allAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
