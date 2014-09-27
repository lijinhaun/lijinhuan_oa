package com.lijinhuan.Base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.lijinhuan.model.Privilege;
import com.lijinhuan.service.DepartmentService;
import com.lijinhuan.service.PrivilegeService;
import com.lijinhuan.service.RoleService;
import com.lijinhuan.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseActionImpl<T> extends ActionSupport implements BaseAction<T>,ModelDriven<T>{

	private Class<T> clazz;
	private BaseActionImpl<T> baseActionImpl;
	public BaseActionImpl(){
		ParameterizedType parameterizedType = (ParameterizedType)clazz.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}
	public T getModel() {
		return (T) clazz;
	}

	@Override
	public String list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String add() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delept() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addUI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editUI() {
		// TODO Auto-generated method stub
		return null;
	}

}
