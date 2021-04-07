package com.vo;

public class JiezhangVo {
	
	private String jzid;
	private Integer mid;
	private String xfid;
	private Double xfje;
	private Double ysje;
	private Double ssje;
	private Double bkzf;
	private Integer oid;
	private java.sql.Timestamp jzdate;
	private Integer jzfs;
	private String state;
	
	
	public String getJzid() {
		return jzid;
	}
	public void setJzid(String jzid) {
		this.jzid = jzid;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getXfid() {
		return xfid;
	}
	public void setXfid(String xfid) {
		this.xfid = xfid;
	}
	public Double getXfje() {
		return xfje;
	}
	public void setXfje(Double xfje) {
		this.xfje = xfje;
	}
	public Double getYsje() {
		return ysje;
	}
	public void setYsje(Double ysje) {
		this.ysje = ysje;
	}
	public Double getSsje() {
		return ssje;
	}
	public void setSsje(Double ssje) {
		this.ssje = ssje;
	}
	public Double getBkzf() {
		return bkzf;
	}
	public void setBkzf(Double bkzf) {
		this.bkzf = bkzf;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public java.sql.Timestamp getJzdate() {
		return jzdate;
	}
	public void setJzdate(java.sql.Timestamp jzdate) {
		this.jzdate = jzdate;
	}
	public Integer getJzfs() {
		return jzfs;
	}
	public void setJzfs(Integer jzfs) {
		this.jzfs = jzfs;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
	@Override
	public String toString() {
		return "JiezhangVo [jzid=" + jzid + ", mid=" + mid + ", xfid=" + xfid
				+ ", xfje=" + xfje + ", ysje=" + ysje + ", ssje=" + ssje
				+ ", bkzf=" + bkzf + ", oid=" + oid + ", jzdate=" + jzdate
				+ ", jzfs=" + jzfs + ", state=" + state + "]";
	}
	
	
	

}
