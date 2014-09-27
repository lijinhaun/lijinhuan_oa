package com.lijinhuan.dao;

import com.lijinhuan.Base.BaseDao;
import com.lijinhuan.model.User;

public interface UserDao extends BaseDao<User>{

	public User checkUser(String username, String password);

}
