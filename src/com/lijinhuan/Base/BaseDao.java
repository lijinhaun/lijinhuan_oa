package com.lijinhuan.Base;

import java.util.List;

public interface BaseDao<T> {

	public void save(T t);
	public void delete(int id);
	public List<T> getByIds(Integer[] ids);
	public 	T getById(int id);
	public List<T> getAll();
	public void update(T t);
}
