package com.lijinhuan.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.lijinhuan.Base.BaseDaoImpl;
import com.lijinhuan.dao.PrivilegeDao;
import com.lijinhuan.model.Privilege;
import com.lijinhuan.service.PrivilegeService;
@Component("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao{

	@Resource
	private SessionFactory sessionFactory;
	public List<Privilege> getTopPrivilegs() {
		List<Privilege> topPrivileges = sessionFactory.getCurrentSession().createQuery("from Privilege p where p.parent is null").list();
		return topPrivileges;
	}

}
