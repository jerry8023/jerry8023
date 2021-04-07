package com.vo;

public class XiaofeiVo {
	
	private String xfid;
	private String bjid;
	private Integer oid;
	private java.sql.Timestamp rzdate;
	//private java.sql.Date rzdate;
	private Double yajin;
	private Integer state;
	private String remarks;
	private String cid;
	
	
	public String getXfid() {
		return xfid;
	}
	public void setXfid(String xfid) {
		this.xfid = xfid;
	}
	public String getBjid() {
		return bjid;
	}
	public void setBjid(String bjid) {
		this.bjid = bjid;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	/*public java.sql.Date getRzdate() {
		return rzdate;
	}
	public void setRzdate(java.sql.Date rzdate) {
		this.rzdate = rzdate;
	}*/
	public Double getYajin() {
		return yajin;
	}
	public void setYajin(Double yajin) {
		this.yajin = yajin;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	
	
	
	public void setRzdate(java.sql.Timestamp rzdate) {
		this.rzdate = rzdate;
	}
	public java.sql.Timestamp getRzdate() {
		return rzdate;
	}
	
	
	
	@Override
	public String toString() {
		return "XiaofeiVo [xfid=" + xfid + ", bjid=" + bjid + ", oid=" + oid
				+ ", rzdate=" + rzdate + ", yajin=" + yajin + ", state="
				+ state + ", remarks=" + remarks + ", cid=" + cid + "]";
	}
	

}
