package com.vo;

public class JieriVo {
	
	private Integer jrid;
	private Integer jfid;
	private String jrname;
	private String jrdate;
	private JifeiVo jifei;
	
	
	public Integer getJrid() {
		return jrid;
	}
	public void setJrid(Integer jrid) {
		this.jrid = jrid;
	}
	public Integer getJfid() {
		return jfid;
	}
	public void setJfid(Integer jfid) {
		this.jfid = jfid;
	}
	public String getJrname() {
		return jrname;
	}
	public void setJrname(String jrname) {
		this.jrname = jrname;
	}
	public String getJrdate() {
		return jrdate;
	}
	public void setJrdate(String jrdate) {
		this.jrdate = jrdate;
	}
	
	
	public JifeiVo getJifei() {
		return jifei;
	}
	public void setJifei(JifeiVo jifei) {
		this.jifei = jifei;
	}
	
	
	@Override
	public String toString() {
		return "JieriVo [jrid=" + jrid + ", jfid=" + jfid + ", jrname="
				+ jrname + ", jrdate=" + jrdate + ", jifei=" + jifei + "]";
	}

	
	
	
}
