package com.lijinhuan.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lijinhuan.dao.DepartmentDao;
import com.lijinhuan.model.Department;
@Component
public class DepartmentService {

	private DepartmentDao departmentDao;
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}
	@Resource
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	/**
	 * 下面是业务逻辑
	 */
	public List<Department> getByparent(Department parent) {
		return departmentDao.getByparent(parent);
	}
	
	public List<Department> getAll() {
		return departmentDao.getAll();
	}
	public Department getById(int id) {
		return departmentDao.getById(id);
	}
	public void save(Department department) {
		departmentDao.save(department);
	}
	public void delete(int id){
		departmentDao.delete(id);
	}
	public void update(Department department) {
		departmentDao.update(department);
	}
	public List<Department> getByIds(Integer[] ids) {
		return departmentDao.getByIds(ids);
	}
	public List<Department> getToplist() {
		
		return departmentDao.getToplist();
	}
}
