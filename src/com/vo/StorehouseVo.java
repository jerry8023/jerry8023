package com.vo;

public class StorehouseVo {
	
	private Integer shid;
	private String shname;
	
	
	
	public Integer getShid() {
		return shid;
	}
	public void setShid(Integer shid) {
		this.shid = shid;
	}
	public String getShname() {
		return shname;
	}
	public void setShname(String shname) {
		this.shname = shname;
	}
	
	
	@Override
	public String toString() {
		return "StorehouseDao [shid=" + shid + ", shname=" + shname + "]";
	}
	
	

}
