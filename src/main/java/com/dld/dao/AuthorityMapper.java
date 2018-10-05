package com.dld.dao;


import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dld.entity.Authority;
import com.dld.entity.Role;


public interface AuthorityMapper {
    
    int addSelective(Authority authority);
    Authority findByTitle(String name);
    Authority findById(Integer id);
    void deleteById(Integer id);
    void updateAuthority(Authority authority);
    Set<String> findRoleByName(String name);
    List<Authority> findByParent(Integer id);
    Set<String> findPermitByName(String name);
    Set<Authority> findByName(String name);
    List<Authority> findMenu(Integer id);
    List<Authority> findPermits(Map<String,Object> info);
    int count();
    List<Authority> allAuthority();
    List<Authority> findRoleAuthorty();
   
  
    
    
   
}