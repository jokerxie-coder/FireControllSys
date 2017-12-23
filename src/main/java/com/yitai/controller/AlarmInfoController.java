package com.yitai.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yitai.model.AlarmInfo;
import com.yitai.service.AlarmInfoService;

@Controller
@RequestMapping("/alarm")
public class AlarmInfoController {

	
	@Resource
	private AlarmInfoService alarmInfoService;
	
	@RequestMapping("/insert")
	
	public @ResponseBody String insertAlarmInfo(AlarmInfo alarmInfo){
		try{
			if(alarmInfo==null){
				
				return "请完善报警信息！";
			}else if(!alarmInfo.getaLocation().isEmpty()){
				
				alarmInfo.setaFlag(0);
				alarmInfoService.insert(alarmInfo);
				
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
			return "报警失败！";
		}
		
		return "报警成功！";
	}
	
}
