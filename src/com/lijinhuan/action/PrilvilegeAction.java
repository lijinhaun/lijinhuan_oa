package com.lijinhuan.action;

import java.util.HashSet;
import java.util.List;

import com.lijinhuan.model.Department;
import com.lijinhuan.model.Privilege;
import com.lijinhuan.model.Role;
import com.lijinhuan.model.User;
import com.lijinhuan.util.MysPasswordToMD5;
import com.lijinhuan.util.listToTree;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PrilvilegeAction extends ActionSupport implements ModelDriven<Privilege>{

	private Privilege privilege = null;
	@Override
	public Privilege getModel() {
		if(privilege == null) {
			privilege = new Privilege();
			return privilege;
		}
		return null;
	}
	/**
	 * 获取列表
	 * @return
	 */
	
	public String list() {
 		return "list";
	}
	/**
	 * 添加
	 * @return
	 */
	public String add() {
		
		return "toList";
	}
	/**
	 * 添加页面
	 * @return
	 */
	public String addUI() {
		
		return "saveUI";
	}
	/**
	 * 修改页面
	 * @return
	 */
	public String editUI() {
		
		return "saveUI";
	}
	//修改
	public String edit() {
	
		return "toList";
	}
	
}
