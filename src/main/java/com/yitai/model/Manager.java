package com.yitai.model;


/**
 * 管理员实体类
 * @author 14292
 *
 */
public class Manager {
	
    private Integer mId;//管理员编号

    private String mName;//管理员姓名
    
    private String mUserName;//管理员用户名

    private String mPassWord;//管理员密码
    
    
    public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	//表示管理员管理的区域
    private Area area;

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Integer getmId() {
		return mId;
	}

	public void setmId(Integer mId) {
		this.mId = mId;
	}

	public String getmUserName() {
		return mUserName;
	}

	public void setmUserName(String mUserName) {
		this.mUserName = mUserName;
	}

	public String getmPassWord() {
		return mPassWord;
	}

	public void setmPassWord(String mPassWord) {
		this.mPassWord = mPassWord;
	}

	@Override
	public String toString() {
		return "Manager [mId=" + mId + ", mName=" + mName + ", mUserName=" + mUserName + ", mPassWord=" + mPassWord
				+ ", area=" + area + "]";
	}

	

   
}