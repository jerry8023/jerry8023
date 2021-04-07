package com.vo;

public class XfdetailVo {
	
	private Integer xfdid;
	private Integer gid;
	private String xfid;
	private Integer numbers;
	private java.sql.Timestamp xfsj;
	private Integer fwsid;
	private Integer oid;
	
	public Integer getXfdid() {
		return xfdid;
	}
	public void setXfdid(Integer xfdid) {
		this.xfdid = xfdid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getXfid() {
		return xfid;
	}
	public void setXfid(String xfid) {
		this.xfid = xfid;
	}
	public Integer getNumbers() {
		return numbers;
	}
	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}
	
	
	
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public java.sql.Timestamp getXfsj() {
		return xfsj;
	}
	public void setXfsj(java.sql.Timestamp xfsj) {
		this.xfsj = xfsj;
	}
	
	
	public Integer getFwsid() {
		return fwsid;
	}
	public void setFwsid(Integer fwsid) {
		this.fwsid = fwsid;
	}
	
	
	@Override
	public String toString() {
		return "XfdetailVo [xfdid=" + xfdid + ", gid=" + gid + ", xfid=" + xfid
				+ ", numbers=" + numbers + ", xfsj=" + xfsj + ", fwsid=" + fwsid
				+ "]";
	}
	
}
