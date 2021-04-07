package com.vo;

public class PrivilegeVo {
	
	private Integer pid;
	private String pname;
	
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	
	@Override
	public String toString() {
		return "PrivilegeDao [pid=" + pid + ", pname=" + pname + "]";
	}
	
	
	

}
