package com.vo;

public class TaocanmingxiVo {
	
	private Integer tcmxid;
	private Integer cid;
	private Integer gid;
	private Integer tcmnumber;
	
	
	public Integer getTcmxid() {
		return tcmxid;
	}
	public void setTcmxid(Integer tcmxid) {
		this.tcmxid = tcmxid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Integer getTcmnumber() {
		return tcmnumber;
	}
	public void setTcmnumber(Integer tcmnumber) {
		this.tcmnumber = tcmnumber;
	}
	
	
	@Override
	public String toString() {
		return "TaocanmingxiVo [tcmxid=" + tcmxid + ", cid=" + cid + ", gid="
				+ gid + ", tcmnumber=" + tcmnumber + "]";
	}
	
	
	

}
