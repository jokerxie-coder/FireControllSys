package com.yitai.service;

import com.yitai.model.Facility;

public interface FacilityService {

	
	public Facility findOne(int id);  
	
	public void update(Facility facility);
}
