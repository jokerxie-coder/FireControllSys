package com.yitai.model;

import java.util.Date;

/**
 * 报警信息实体类
 * @author 14292
 *
 */
public class AlarmInfo {

	
	private Integer aId;//报警信息编号
	private String aLocation;//火灾发生地点
	private Date aDate;//火灾发生时间
	private Integer aFlag;//报警信息类型编号
	public Integer getaId() {
		return aId;
	}
	public void setaId(Integer aId) {
		this.aId = aId;
	}
	
	
	public Date getaDate() {
		return aDate;
	}
	public void setaDate(Date aDate) {
		this.aDate = aDate;
	}
	public String getaLocation() {
		return aLocation;
	}
	public void setaLocation(String aLocation) {
		this.aLocation = aLocation;
	}
	public Integer getaFlag() {
		return aFlag;
	}
	public void setaFlag(Integer aFlag) {
		this.aFlag = aFlag;
	}
	@Override
	public String toString() {
		return "Alarm [aId=" + aId + ", aLocation=" + aLocation + ", aDate=" + aDate + ", aFlag=" + aFlag + "]";
	}
	
	
}
