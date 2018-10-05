package com.dld.service;

import java.util.List;
import java.util.Set;

import com.dld.entity.Authority;
import com.dld.entity.Role;

public interface IAuthorityService {
	public Set<String> findPermitByName(String name);
	public List<Authority> menu(Integer id);
	public int count();
	public List<Authority> findAllPermits(int page,int size);
	public void addAuthority(Authority authority);
	public Authority findById(Integer id);
	public void deleteById(Integer id);
    public void updateAuthority(Authority authority);
    List<Authority> allAuthority();
   
}
