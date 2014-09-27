package com.lijinhuan.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jms.Session;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.Parent;
import org.springframework.stereotype.Component;

import com.lijinhuan.Base.BaseDaoImpl;
import com.lijinhuan.dao.DepartmentDao;
import com.lijinhuan.model.Department;
@Component
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao{
	@Resource
	private SessionFactory sessionFactory ;
	public List<Department> getByparent(Department parent) {
		if(parent == null){
			return sessionFactory.getCurrentSession().createQuery("from Department d where d.parent is null").list();
					//.setParameter("parent", null) .list();
		}
		//System.out.println(parent.getName()+"<-------->");
		return sessionFactory.getCurrentSession().createQuery("from Department d where d.parent=:parent")
				.setParameter("parent", parent)
				.list();
	}
	public List<Department> getToplist() {
		
		List<Department> topDepartments = sessionFactory.getCurrentSession().createQuery("FROM Department d WHERE d.parent IS NULL").list();
		sessionFactory.getCurrentSession().evict(topDepartments);
		return topDepartments;
	}
}
