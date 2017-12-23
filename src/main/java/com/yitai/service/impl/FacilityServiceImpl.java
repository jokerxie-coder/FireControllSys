package com.yitai.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yitai.dao.FacilityDao;
import com.yitai.model.Facility;
import com.yitai.service.FacilityService;


@Transactional //使用注解开启事务
@Service("facilityService")
public class FacilityServiceImpl implements FacilityService{

	//使用注解注入facilityDao对象
	@Resource  
	public FacilityDao facilityDao;
	
	@Override
	public Facility findOne(int id) {
		
		return this.facilityDao.findOne(id);
	}

	@Override
	public void update(Facility facility) {

		this.facilityDao.update(facility);
		
	}


}
