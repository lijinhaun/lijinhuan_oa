package com.lijinhuan.dao.impl;

import java.text.Normalizer.Form;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.lijinhuan.Base.BaseDao;
import com.lijinhuan.Base.BaseDaoImpl;
import com.lijinhuan.dao.UserDao;
import com.lijinhuan.model.User;
import com.lijinhuan.util.MysPasswordToMD5;
@Component("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	
	@Resource
	private SessionFactory sessionFactory;
	public User checkUser(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		//System.out.println(username +" ---------------"+password); 
		User user = (User)session.createQuery("from User u where u.username=:username and u.password=:password") //
		.setParameter("username", username)
		.setParameter("password", new MysPasswordToMD5().EncodingToMD5(password))
		.uniqueResult();
		return user;
	}

}
