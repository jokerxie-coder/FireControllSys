package com.yitai.model;

import java.util.Date;


/**
 * 火情信息实体类
 * @author 14292
 *
 */
public class FireInfo  {
	
    private Integer frId;//编号

    private Date frDate;//发生时间

    private String frLocation;//发生地点

    private Integer frRank;//危险等级

    //是否紧急
    //默认为0，如果是专业人士上报火情，则为1；
    //如果为普通用户上报火情，则为0
    private Integer frUrgent;

    private String frDescr;//火情的具体情况描述
    
    private String frImageUrl;//火情现场图片url
    
    

	public String getFrImageUrl() {
		return frImageUrl;
	}

	public void setFrImageUrl(String frImageUrl) {
		this.frImageUrl = frImageUrl;
	}

	public Integer getFrId() {
		return frId;
	}

	public void setFrId(Integer frId) {
		this.frId = frId;
	}

	

	public Date getFrDate() {
		return frDate;
	}

	public void setFrDate(Date frDate) {
		this.frDate = frDate;
	}

	public String getFrLocation() {
		return frLocation;
	}

	public void setFrLocation(String frLocation) {
		this.frLocation = frLocation;
	}

	public Integer getFrRank() {
		return frRank;
	}

	public void setFrRank(Integer frRank) {
		this.frRank = frRank;
	}

	public Integer getFrUrgent() {
		return frUrgent;
	}

	public void setFrUrgent(Integer frUrgent) {
		this.frUrgent = frUrgent;
	}

	public String getFrDescr() {
		return frDescr;
	}

	public void setFrDescr(String frDescr) {
		this.frDescr = frDescr;
	}

	@Override
	public String toString() {
		return "FireInfo [frId=" + frId + ", frDate=" + frDate + ", frLocation=" + frLocation + ", frRank=" + frRank
				+ ", frUrgent=" + frUrgent + ", frDescr=" + frDescr + ", frImageUrl=" + frImageUrl + "]";
	}

	
	

   
}