package com.lijinhuan.dao;

import java.util.List;

import com.lijinhuan.Base.BaseDao;
import com.lijinhuan.model.Privilege;
import com.lijinhuan.service.PrivilegeService;

public interface PrivilegeDao extends BaseDao<Privilege>{

	List<Privilege> getTopPrivilegs();

}
