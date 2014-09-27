package com.lijinhuan.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lijinhuan.dao.PrivilegeDao;
import com.lijinhuan.model.Privilege;
@Component 
public class PrivilegeService {
		
	private PrivilegeDao privilegeDao;

	public PrivilegeDao getPrivilegeDao() {
		return privilegeDao;
	}
	@Resource
	public void setPrivilegeDao(PrivilegeDao privilegeDao) {
		this.privilegeDao = privilegeDao;
	}
	
	public List<Privilege> getAll() {
		return privilegeDao.getAll();
	}
	public void delete(int id) {
		privilegeDao.delete(id);
	}
	public void update(Privilege privilege) {
		privilegeDao.update(privilege);
	}
	public Privilege getById(int id) {
		return privilegeDao.getById(id);
	}
	public List<Privilege> getByIds(Integer[] ids) {
		return privilegeDao.getByIds(ids);
	}
	public void save(Privilege privilege) {
		privilegeDao.save(privilege);
	}
	public List<Privilege> getTopPrivileges() {
		return privilegeDao.getTopPrivilegs();
	}
 }
