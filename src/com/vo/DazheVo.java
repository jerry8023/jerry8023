package com.vo;

public class DazheVo {
	
	private String dzname;
	private Integer mgid;
	private Double dzbl;
	private Double dzremarks;
	private MgradeVo mgradeVo;
	
	
	
	public String getDzname() {
		return dzname;
	}
	public void setDzname(String dzname) {
		this.dzname = dzname;
	}
	public Integer getMgid() {
		return mgid;
	}
	public void setMgid(Integer mgid) {
		this.mgid = mgid;
	}
	public Double getDzbl() {
		return dzbl;
	}
	public void setDzbl(Double dzbl) {
		this.dzbl = dzbl;
	}
	public Double getDzremarks() {
		return dzremarks;
	}
	public void setDzremarks(Double dzremarks) {
		this.dzremarks = dzremarks;
	}
	
	public MgradeVo getMgradeVo() {
		return mgradeVo;
	}
	
	
	@Override
	public String toString() {
		return "DazheVo [dzname=" + dzname + ", mgid=" + mgid + ", dzbl="
				+ dzbl + ", dzremarks=" + dzremarks + ", mgradeVo=" + mgradeVo
				+ "]";
	}
	
	
	

}
