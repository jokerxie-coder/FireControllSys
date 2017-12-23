package com.yitai.dao;

import com.yitai.model.Manager;

public interface ManagerDao extends BaseDao<Manager>{

	public Manager findByUserName(String userName);
}
