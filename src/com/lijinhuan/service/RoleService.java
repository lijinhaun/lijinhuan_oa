package com.lijinhuan.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lijinhuan.dao.RoleDao;
import com.lijinhuan.model.Role;
@Component
public class RoleService {

	private RoleDao roleDao;
	public RoleDao getRoleDao() {
		return roleDao;
	}
	@Resource
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	public void save(Role role) {
		roleDao.save(role);
	}
	public void delete(int id) {
		roleDao.delete(id);
	}
	public Role getById(int id) {
		return (Role) roleDao.getById(id);
	}
	public List<Role> getByIds(Integer[] ids) {
		return roleDao.getByIds(ids);
	}
	public List<Role> getAll() {
		return roleDao.getAll();
	}
	public void update(Role role) {
	//	System.out.println("update----------------------------------------------");
		roleDao.update(role); 
	}
}
