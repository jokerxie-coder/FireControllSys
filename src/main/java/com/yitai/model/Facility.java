package com.yitai.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;




/**
 * 设备信息实体类
 * @author 14292
 *
 */
public class Facility{
    
	private Integer fId;//编号

    private String fName;//名称

    private String fModelNumber;//型号

    
   @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fProDate;//生产日期

    private Integer fExpTime;//有效期

    private String fProducter;//生产厂商
    
    private String fIntroduction;//介绍
    
    private String fUseMethod;//使用方法

    private Area area;//区域实例对象

    private String fContaction;//联系方式

    private String fImageUrl;//图片url

    private String fLocation;//位置信息
    
    

	public String getfIntroduction() {
		return fIntroduction;
	}

	public void setfIntroduction(String fIntroduction) {
		this.fIntroduction = fIntroduction;
	}

	public String getfUseMethod() {
		return fUseMethod;
	}

	public void setfUseMethod(String fUseMethod) {
		this.fUseMethod = fUseMethod;
	}

	public Integer getfId() {
		return fId;
	}

	public void setfId(Integer fId) {
		this.fId = fId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfModelNumber() {
		return fModelNumber;
	}

	public void setfModelNumber(String fModelNumber) {
		this.fModelNumber = fModelNumber;
	}

	
	public Date getfProDate() {
		return fProDate;
	}

	public void setfProDate(Date fProDate) {
		this.fProDate = fProDate;
	}

	

	public Integer getfExpTime() {
		return fExpTime;
	}

	public void setfExpTime(Integer fExpTime) {
		this.fExpTime = fExpTime;
	}

	public String getfProducter() {
		return fProducter;
	}

	public void setfProducter(String fProducter) {
		this.fProducter = fProducter;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getfContaction() {
		return fContaction;
	}

	public void setfContaction(String fContaction) {
		this.fContaction = fContaction;
	}

	public String getfImageUrl() {
		return fImageUrl;
	}

	public void setfImageUrl(String fImageUrl) {
		this.fImageUrl = fImageUrl;
	}

	public String getfLocation() {
		return fLocation;
	}

	public void setfLocation(String fLocation) {
		this.fLocation = fLocation;
	}

	@Override
	public String toString() {
		return "Facility [fId=" + fId + ", fName=" + fName + ", fModelNumber=" + fModelNumber + ", fProDate=" + fProDate
				+ ", fExpTime=" + fExpTime + ", fProducter=" + fProducter + ", fIntroduction=" + fIntroduction
				+ ", fUseMethod=" + fUseMethod + ", area=" + area + ", fContaction=" + fContaction + ", fImageUrl="
				+ fImageUrl + ", fLocation=" + fLocation + "]";
	}

	

	
    

    
}