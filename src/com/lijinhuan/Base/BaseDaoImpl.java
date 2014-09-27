package com.lijinhuan.Base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

public class BaseDaoImpl<T> implements BaseDao<T>{

	private Class<T> clazz;
	
	public BaseDaoImpl() {
		
		//使用反射技术获取T 的真实类型
		ParameterizedType parameterizedType = (ParameterizedType)this.getClass().getGenericSuperclass();//得到new的对象的父类的类型
		//得到父类泛型参数的类型   因为可以有多个泛型的参数  所以返回值是一个数组
		this.clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		System.out.println("------------>"+clazz);
	}
	
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		//System.out.println("<______________________________________>"+sessionFactory);
	}

	public void save(T t) {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Object object = (Object)getById(id);
		session.delete(object);
	}

	

	@Override
	public T getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (T)session.get(clazz, id);
	}
	public List<T> getByIds(Integer[] ids) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from "+clazz.getSimpleName() +" r where r.id in (:ids)")
				.setParameterList("ids", ids)
				.list();
	}
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from "+clazz.getSimpleName()).list();
	}
	@Override
	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);	
	}

}
