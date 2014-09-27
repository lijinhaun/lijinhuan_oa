package com.lijinhuan.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.output.NullWriter;
import org.hibernate.annotations.Parent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lijinhuan.model.Department;
import com.lijinhuan.service.DepartmentService;
import com.lijinhuan.util.listToTree;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
	private Department department = null;
	private DepartmentService departmentService;
	private int parentId;
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	@Resource
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public Department getModel() {
		if(department == null) {
			department = new Department();
		}
		return department;
	}
	public String superList() {
		int superParentId  = 0;
		List<Department> departments = null;
		if(departmentService.getById(parentId) != null && departmentService.getById(parentId).getParent() != null) {
			superParentId = departmentService.getById(parentId).getParent().getId();
			departments = departmentService.getByparent(departmentService.getById(superParentId));
			parentId = superParentId;
		}else{
			departments = departmentService.getByparent(null);
		} 
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("departments", departments);
		return "list";
	}
	public String list() {
		List<Department> departments = null;
		if(departmentService.getById(parentId) == null) {
			 departments = departmentService.getByparent(null);
		}else {
			departments =departmentService.getByparent(departmentService.getById(parentId));
		}
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("departments", departments);
 		return "list";
	}
	public String add() {
		if(departmentService.getById(parentId) != null) {
			parentId = departmentService.getById(parentId).getId();
			Department parent = departmentService.getById(parentId);
			department.setParent(parent);
		}else {
			department.setParent(null);
		}
		departmentService.save(department);
		return "toList";
	}
	public String addUI() {
		List<Department> departments = departmentService.getAll();
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("departments", departments);
		return "saveUI";
	}
	public String editUI() {
		List<Department> departments = departmentService.getAll();
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("departments", departments);
		department= departmentService.getById(department.getId());
		actionContext.getValueStack().push(department);
		if(department.getParent() != null) {
			parentId = department.getParent().getId();
		}
		return "saveUI";
	}
	public String edit() {
		Department parent = departmentService.getById(parentId);
		department.setParent(parent);
		//更新源对象
		departmentService.update(department);
		return "toList";
	}
	public String delete() {
		departmentService.delete(department.getId());
		return "toList";
	}
}
