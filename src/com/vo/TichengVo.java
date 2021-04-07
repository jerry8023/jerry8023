package com.vo;

public class TichengVo {
	
	private Integer gid;
	private Integer sgid;
	private Double ld;
	private Double dd;
	
	
	
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Integer getSgid() {
		return sgid;
	}
	public void setSgid(Integer sgid) {
		this.sgid = sgid;
	}
	public Double getLd() {
		return ld;
	}
	public void setLd(Double ld) {
		this.ld = ld;
	}
	public Double getDd() {
		return dd;
	}
	public void setDd(Double dd) {
		this.dd = dd;
	}
	
	
	@Override
	public String toString() {
		return "TichengVo [gid=" + gid + ", sgid=" + sgid + ", ld=" + ld
				+ ", dd=" + dd + "]";
	}
	
	
	

}
