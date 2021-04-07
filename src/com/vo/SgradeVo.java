package com.vo;

public class SgradeVo {
	
	private Integer sgid;
	private String sgname;
	
	
	public Integer getSgid() {
		return sgid;
	}
	public void setSgid(Integer sgid) {
		this.sgid = sgid;
	}
	public String getSgname() {
		return sgname;
	}
	public void setSgname(String sgname) {
		this.sgname = sgname;
	}
	
	
	@Override
	public String toString() {
		return "SgradeDao [sgid=" + sgid + ", sgname=" + sgname + "]";
	}
	
	
	

}
