package com.vo;

public class BaojiantypeVo {
	
	private Integer bjtid;
	private Integer jrid;
	private String bjtname;
	private Double minxf=0.0;
	private Integer rnrs;
	private Integer jrid1;
	private Integer jrid2;
	private Integer jridt;
	
	
	public Integer getBjtid() {
		return bjtid;
	}
	public void setBjtid(Integer bjtid) {
		this.bjtid = bjtid;
	}
	public Integer getJrid() {
		return jrid;
	}
	public void setJrid(Integer jrid) {
		this.jrid = jrid;
	}
	public String getBjtname() {
		return bjtname;
	}
	public void setBjtname(String bjtname) {
		this.bjtname = bjtname;
	}
	public Double getMinxf() {
		return minxf;
	}
	public void setMinxf(Double minxf) {
		this.minxf = minxf;
	}
	public Integer getRnrs() {
		return rnrs;
	}
	public void setRnrs(Integer rnrs) {
		this.rnrs = rnrs;
	}
	
	
	
	public Integer getJrid1() {
		return jrid1;
	}
	public void setJrid1(Integer jrid1) {
		this.jrid1 = jrid1;
	}
	public Integer getJrid2() {
		return jrid2;
	}
	public void setJrid2(Integer jrid2) {
		this.jrid2 = jrid2;
	}
	public Integer getJridt() {
		return jridt;
	}
	public void setJridt(Integer jridt) {
		this.jridt = jridt;
	}
	
	
	@Override
	public String toString() {
		return "BaojiantypeVo [bjtid=" + bjtid + ", jrid=" + jrid
				+ ", bjtname=" + bjtname + ", minxf=" + minxf + ", rnrs="
				+ rnrs + ", jrid1=" + jrid1 + ", jrid2=" + jrid2 + ", jridt="
				+ jridt + "]";
	}
	
	
	

}
