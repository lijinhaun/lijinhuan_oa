package com.lijinhuan.action;

import java.applet.AppletContext;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.portlet.handler.UserRoleAuthorizationInterceptor;

import com.lijinhuan.model.Department;
import com.lijinhuan.model.Role;
import com.lijinhuan.model.User;
import com.lijinhuan.service.DepartmentService;
import com.lijinhuan.service.RoleService;
import com.lijinhuan.service.UserService;
import com.lijinhuan.util.MysPasswordToMD5;
import com.lijinhuan.util.listToTree;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import freemarker.cache.StringTemplateLoader;
@Component
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{

	private User user = null;
	@Override
	public User getModel() {
		if(user == null) {
			user = new User();
		}
		return user; 
	}
	private RoleService roleService;
	private UserService userService;
	private DepartmentService departmentService;
	
	
	private int departmentId;
	private Integer[] roleIds;
	public String list() {
		//准备数据
		List<User> users = userService.getAll();
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("users", users);
		
 		return "list";
	}
	public String add() {
		//1.封装数据
		Department department = departmentService.getById(departmentId);
		List<Role> roles = roleService.getByIds(roleIds);
		user.setDepartment(department);
		user.setRoles(new HashSet<Role>(roles));
		//设置密码为“1234”
		user.setPassword(new MysPasswordToMD5().EncodingToMD5("1234"));
		//2.保存到数据库
		userService.save(user);
		
		return "toList";
	}
	public String addUI() {
		//准备数据
		List<Department> topDepartments = departmentService.getToplist();
		List<Department> departments = listToTree.getDepartmentTree(topDepartments);
		//List<Department> departments = departmentService.getAll();
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("departments", departments);
		List<Role> roles = roleService.getAll();
		actionContext.put("roles", roles);
		return "saveUI";
	}
	
	public String editUI() {
		//准备需要的数据
		List<Department> departments = departmentService.getAll();
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("departments", departments);
		List<Role> roles = roleService.getAll();
		actionContext.put("roles", roles);
		//准备回显数据
		user = userService.getById(user.getId());
		
		if(user.getDepartment() != null) {
			departmentId = user.getDepartment().getId();
		}
		if(user.getRoles() != null) {
			roleIds = new Integer[user.getRoles().size()];
			int index = 0;
			for (Role role : user.getRoles()) {
				roleIds[index++] = role.getId();
			}
		}
		actionContext.getValueStack().push(user);
		return "saveUI";
	}
	//修改
	public String edit() {
		//1.从数据库中取出源对象
		User newUser = userService.getById(user.getId());
		//2.设置要修改的属性
		newUser.setDescription(user.getDescription());
		newUser.setEmail(user.getEmail());
		newUser.setName(user.getName());
		newUser.setPhoneNumber(user.getPhoneNumber());
		newUser.setSex(user.getSex());
		newUser.setUsername(user.getUsername());
		//设置部门
		newUser.setDepartment(departmentService.getById(departmentId));
		//设置岗位
		newUser.setRoles(new HashSet<Role>(roleService.getByIds(roleIds)));
		//3.更新到数据库
		userService.update(newUser);
		
		
		return "toList";
	}
	public String delete() {
		userService.delete(user.getId());
		return "toList";
	}
	public String initPassword() {
		User initPasswordUser = userService.getById(user.getId());
		initPasswordUser.setPassword(new MysPasswordToMD5().EncodingToMD5("1234"));
		userService.update(initPasswordUser);
		return "toList";
	}
	public String editPasswordUI() {
		user = userService.getById(user.getId());
		ActionContext actionContext = ActionContext.getContext();
		actionContext.getValueStack().push(user);
		return "editPasswordUI";
	}
	public String editPassword() {
		User editPassword = userService.getById(user.getId());
		String newPasswordString = new MysPasswordToMD5().EncodingToMD5(user.getPassword());
		editPassword.setPassword(newPasswordString);
		userService.update(editPassword);
		return "toList";
	}
	
	public String login() {
		User loginUser = userService.checkUser(user.getUsername(), user.getPassword());
		if(loginUser != null){
			ActionContext.getContext().getSession().put("loginUser",loginUser);
			return "index";
		}else {
			addFieldError("loginErr", getText("您输入的密码或用户名错误"));
			return "login";
		}
	}
	public String logout() {
		ActionContext.getContext().getSession().clear();
		return "toLogin";
	}
	
	public RoleService getRoleService() {
		return roleService;
	}
	@Resource
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public UserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	@Resource
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public Integer[] getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(Integer[] roleIds) {
		this.roleIds = roleIds;
	}
	
}
