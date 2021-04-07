package com.vo;

public class GoodstypeVo {
	
	private Integer gtid;
	private String gtname;
	private Integer isserve;
	
	
	public Integer getGtid() {
		return gtid;
	}
	public void setGtid(Integer gtid) {
		this.gtid = gtid;
	}
	public String getGtname() {
		return gtname;
	}
	public void setGtname(String gtname) {
		this.gtname = gtname;
	}
	public Integer getIsserve() {
		return isserve;
	}
	public void setIsserve(Integer isserve) {
		this.isserve = isserve;
	}
	
	
	@Override
	public String toString() {
		return "GoodstypeVo [gtid=" + gtid + ", gtname=" + gtname
				+ ", isserve=" + isserve + "]";
	}
	
	
	
	

}
