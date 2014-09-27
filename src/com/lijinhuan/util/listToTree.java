package com.lijinhuan.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.lijinhuan.model.Department;

public class listToTree {

	public static List<Department> getDepartmentTree(List<Department> topDepartments) {
		//System.out.println("11111111111111111111111111111111111111111");
		List<Department> list = new ArrayList<Department>();
		getTree(topDepartments,"┠",list);
		return list;
	}
	private static void getTree(Collection<Department> topDepartments,String prefix,List<Department> list) {
		int index = 0;
		for (Department department : topDepartments) {
			Department copy = new Department();
			copy.setId(department.getId());
			copy.setName(prefix+department.getName());
			
			list.add(copy);
			//list.get(index++).setName(prefix+department.getName());
			//System.out.println(list.get(--index).getName());
			getTree(department.getChildren(),"　"+prefix, list);
			//index++;
		}
	}
}
