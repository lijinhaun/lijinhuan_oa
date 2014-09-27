package com.lijinhuan.action;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lijinhuan.model.Department;
import com.lijinhuan.model.Privilege;
import com.lijinhuan.model.Role;
import com.lijinhuan.model.User;
import com.lijinhuan.service.PrivilegeService;
import com.lijinhuan.service.RoleService;
import com.lijinhuan.util.listToTree;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component
@Scope("prototype")
public class RoleAction extends ActionSupport implements ModelDriven<Role> {
	private PrivilegeService privilegeService;
	private RoleService roleService;
	private Integer[] privilegeIds;
	public Integer[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Integer[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

	private Role role = null;
	@Override
	public Role getModel() {
		if (role == null) {
			role = new Role();
		}
		return role;
	}

	public String list() {
		List<Role> roles = roleService.getAll();
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("roles", roles);
		return "list";
	}

	public String editUI() {
		role = roleService.getById(role.getId());
		
		ActionContext actionContext = ActionContext.getContext();
		actionContext.getValueStack().push(role);
		return "saveUI";
	}

	// 添加页面
	public String addUI() {
		return "saveUI";
	}

	// 添加
	public String add() {
		roleService.save(role);
		return "toList";
	}

	// 修改
	public String edit() {
		Role newRole = roleService.getById(role.getId());
		newRole.setDescription(role.getDescription());
		newRole.setName(role.getName());
		newRole.setPrivileges(role.getPrivileges());
		roleService.update(newRole);
		return "toList";
	}

	public String delete() {
		roleService.delete(role.getId());
		return "toList";
	}

	public String setPrivilegeUI() {
		// 准备回显数据
		Role showRole = roleService.getById(role.getId());
		System.err.println(showRole.getPrivileges().size()+"<--------------------------------------------");
		ActionContext actionContext = ActionContext.getContext();
		actionContext.getValueStack().push(showRole);
		if(showRole.getPrivileges() != null) {
			privilegeIds = new Integer[showRole.getPrivileges().size()];
			int index = 0;
			for (Privilege privilege : showRole.getPrivileges()) {
				privilegeIds[index++] = privilege.getId();
			}
		}
		
		
		List<Privilege> privileges = privilegeService.getAll();
		ActionContext.getContext().put("privileges", privileges);
		//ActionContext.getContext().getValueStack().push(privilegeIds);
		return "setPrivilegeUI";
	}
	
	public String setPrivilege() {
		//System.out.println("ok!");
		List<Privilege> privileges = privilegeService.getByIds(privilegeIds);
		Role newRole = roleService.getById(role.getId());
		newRole.setPrivileges(new HashSet<Privilege>(privileges));
 		roleService.update(newRole);
		return "toList";
	}

	public PrivilegeService getPrivilegeService() {
		return privilegeService;
	}

	@Resource
	public void setPrivilegeService(PrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	@Resource
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
}
