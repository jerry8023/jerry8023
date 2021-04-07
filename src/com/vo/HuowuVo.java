package com.vo;

public class HuowuVo {
	
	private String hid;
	private Integer drsh;
	private Integer dcsh;
	private Integer sid;
	private Integer oid;
	private Double yfzk;
	private Double sfzk;
	private String remarks;
	private Integer state;
	private java.sql.Date tddate;
	
	
	
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	public Integer getDrsh() {
		return drsh;
	}
	public void setDrsh(Integer drsh) {
		this.drsh = drsh;
	}
	public Integer getDcsh() {
		return dcsh;
	}
	public void setDcsh(Integer dcsh) {
		this.dcsh = dcsh;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Double getYfzk() {
		return yfzk;
	}
	public void setYfzk(Double yfzk) {
		this.yfzk = yfzk;
	}
	public Double getSfzk() {
		return sfzk;
	}
	public void setSfzk(Double sfzk) {
		this.sfzk = sfzk;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public java.sql.Date getTddate() {
		return tddate;
	}
	public void setTddate(java.sql.Date tddate) {
		this.tddate = tddate;
	}
	
	
	
	@Override
	public String toString() {
		return "HuowuVo [hid=" + hid + ", drsh=" + drsh + ", dcsh=" + dcsh
				+ ", sid=" + sid + ", oid=" + oid + ", yfzk=" + yfzk
				+ ", sfzk=" + sfzk + ", remarks=" + remarks + ", state="
				+ state + ", tddate=" + tddate + "]";
	}
	
	
	
	
	
	
	
	

}
