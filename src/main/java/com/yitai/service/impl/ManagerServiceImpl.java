package com.yitai.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yitai.dao.ManagerDao;
import com.yitai.model.Manager;
import com.yitai.service.ManagerService;


@Transactional //使用注解开启事务
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
	
	//使用注解注入managerDao对象
	@Resource  
	public ManagerDao managerDao;
	
	@Override
	public Manager findByUserName(String userName) {
	
		return this.managerDao.findByUserName(userName);
	}

}
