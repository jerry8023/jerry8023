package com.vo;

public class PdetailVo {
	
	private Integer pid;
	
	private Integer rid;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	@Override
	public String toString() {
		return "PdetailDao [pid=" + pid + ", rid=" + rid + "]";
	}
	
	
	
	

}
