package com.lijinhuan.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lijinhuan.dao.UserDao;
import com.lijinhuan.model.User;
@Component
public class UserService {

	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void  save(User user){
		System.err.println("userservice"+user.getUsername());
		userDao.save(user);
	}
	public void delete(int id){
		userDao.delete(id);
	}
	public User getById(int id) {
		return (User) userDao.getById(id);
	}
	public List<User> getByIds(Integer[] ids) {
		return userDao.getByIds(ids);
	}
	public List<User> getAll() {
		return userDao.getAll();
	}
	public void update(User user) {
		userDao.update(user);
	}
	public User checkUser(String username, String password) {
		return userDao.checkUser(username,password);	
	}
}
