package com.yitai.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yitai.dao.AlarmInfoDao;
import com.yitai.model.AlarmInfo;
import com.yitai.service.AlarmInfoService;

@Transactional
@Service("alarmService")
public class AlarmInfoServiceImpl implements AlarmInfoService {

	
	@Resource
	private AlarmInfoDao alarmInfoDao;
	@Override
	public void insert(AlarmInfo alarmInfo) {
		
		this.alarmInfoDao.insert(alarmInfo);
	}

}
