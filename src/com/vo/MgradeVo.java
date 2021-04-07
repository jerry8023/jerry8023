package com.vo;

public class MgradeVo {
	
	private Integer mgid;
	private String mgname;
	private Integer csjf;
	private Double rebate;
	private Integer usenumber;
	
	
	
	public Integer getMgid() {
		return mgid;
	}
	public void setMgid(Integer mgid) {
		this.mgid = mgid;
	}
	public String getMgname() {
		return mgname;
	}
	public void setMgname(String mgname) {
		this.mgname = mgname;
	}
	public Integer getCsjf() {
		return csjf;
	}
	public void setCsjf(Integer csjf) {
		this.csjf = csjf;
	}
	public Double getRebate() {
		return rebate;
	}
	public void setRebate(Double rebate) {
		this.rebate = rebate;
	}
	public Integer getUsenumber() {
		return usenumber;
	}
	public void setUsenumber(Integer usenumber) {
		this.usenumber = usenumber;
	}
	
	
	@Override
	public String toString() {
		return "MgradeVo [mgid=" + mgid + ", mgname=" + mgname + ", csjf="
				+ csjf + ", rebate=" + rebate + ", usenumber=" + usenumber
				+ "]";
	}
	
	

}
