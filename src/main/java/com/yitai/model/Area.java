package com.yitai.model;

import java.util.List;


/**
 * 区域实体类
 * @author 14292
 *
 */
public class Area{
	
	
    private Integer areaId;//区域编号

    private String areaName;//区域名称

	private Manager manager;//区域所属的管理员对象
	
	//表示区域中的多个设备
	private List<Facility> facilityList;

	
	public List<Facility> getFacilityList() {
		return facilityList;
	}

	public void setFacilityList(List<Facility> facilityList) {
		this.facilityList = facilityList;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Area [areaId=" + areaId + ", areaName=" + areaName + ", manager=" + manager + ", facilityList="
				+ facilityList + "]";
	}
	
	
    
}