package com.lijinhuan.util;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lijinhuan.model.Privilege;
import com.lijinhuan.model.User;

@Component
public class InstallPrivilegeData {
	@Resource
	private SessionFactory sessionFactory;

	private Privilege menu,menu1,menu2,menu3,menu4,menu5;
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		InstallPrivilegeData installPrivilegeData= (InstallPrivilegeData) applicationContext.getBean("installPrivilegeData");
		//System.out.println(sessionFactory);
		installPrivilegeData.installData();
	}
	
	/**
	 * 初始化安装privilege数据
	 */
	
	public void installData() {
		/**
		 * 添加管理员帐号
		 */
		User user = new User();
		user.setUsername("admin");
		user.setName("超级管理员");
		user.setPassword(new MysPasswordToMD5().EncodingToMD5("admin"));
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		/**
		 * menu  顶级权限
		 */
		menu = new Privilege("系统管理管理", null, null);
		session.save(menu);
		
		menu1 = new Privilege("部门管理", "/departmentAction_list", menu);
		menu2 = new Privilege("岗位管理", "/roleAction_list", menu);
		menu3 = new Privilege("用户管理", "/userAction_list", menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		
		
		
		session.save(new Privilege("部门列表", "/deparmentAction_list", menu1));
		session.save(new Privilege("部门添加", "/deparmentAction_addUI", menu1));
		session.save(new Privilege("部门删除", "/deparmentAction_delete", menu1));
		session.save(new Privilege("部门修改", "/deparmentAction_editUI", menu1));
		
		session.save(new Privilege("岗位列表", "/roleAction_list", menu2));
		session.save(new Privilege("岗位添加", "/roleAction_addUI", menu2));
		session.save(new Privilege("岗位删除", "/roleAction_delete", menu2));
		session.save(new Privilege("岗位修改", "/roleAction_editUI", menu2));
		
		session.save(new Privilege("用户列表", "/userAction_list", menu3));
		session.save(new Privilege("用户添加", "/userAction_addUI", menu3));
		session.save(new Privilege("用户删除", "/userAction_delete", menu3));
		session.save(new Privilege("用户修改", "/userAction_editUI", menu3));
			
		//--------------------------
		menu = new Privilege("网上交流", null, null);
		session.save(menu);
		
		menu1 = new Privilege("论坛管理", "/forumManager_list", menu);
		menu2 = new Privilege("论坛", "forum_list", menu);
		session.save(menu1);
		session.save(menu2);
		
		
		menu = new Privilege("审批流转", null, null);
		session.save(menu);
		
		menu1 = new Privilege("审批流程管理", "/processDefinition_list", menu);
		menu2 = new Privilege("申请模板管理", "/template_list", menu);
		menu3 = new Privilege("起草申请", "/flow_templatList", menu);
		menu4 = new Privilege("待我审批", "/flow_myTaskList", menu);
		menu5 = new Privilege("我的申请查询", "/flow_myApplicationList", menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
		session.save(menu5);
	}
}
