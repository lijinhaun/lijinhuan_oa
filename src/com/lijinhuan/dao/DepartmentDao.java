package com.lijinhuan.dao;

import java.util.List;

import org.hibernate.annotations.Parent;

import com.lijinhuan.Base.BaseDao;
import com.lijinhuan.model.Department;

public interface DepartmentDao extends BaseDao<Department>{

	public List<Department> getByparent(Department parent);

	public List<Department> getToplist();
}
