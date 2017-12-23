package com.yitai.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yitai.dao.FireInfoDao;
import com.yitai.model.FireInfo;
import com.yitai.service.FireInfoService;

@Transactional //使用注解开启事务
@Service("fireInfoService")
public class FireInfoServiceImpl implements FireInfoService {

	//使用注解注入fireInfoDao对象
	@Resource  
	public FireInfoDao fireInfoDao;
	
	@Override
	public void insert(FireInfo fireInfo) {
		
		this.fireInfoDao.insert(fireInfo);

	}

}
