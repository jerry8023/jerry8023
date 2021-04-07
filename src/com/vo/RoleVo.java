package com.vo;

public class RoleVo {
	
	private Integer rid;
	private String rname;
	
	
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	
	
	@Override
	public String toString() {
		return "RoleDao [rid=" + rid + ", rname=" + rname + "]";
	}
	
	
	

}
