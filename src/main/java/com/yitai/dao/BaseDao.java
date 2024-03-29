package com.yitai.dao;

import java.util.List;

/**
 * 定义类型是 T,代表任意类型
 * （1）任意类型使用大写字母表示，不一定是T
 * @author Administrator
 *
 * @param <T>
 */
public interface BaseDao<T> {
	
	
	//添加
	void insert(T t);
	
	//修改
	void update(T t);
	
	//删除
	void delete(T t);
	
	//根据id查询
	T findOne(int id);
	
	//查询所有
	List<T> findAll();

}

