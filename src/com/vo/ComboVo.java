package com.vo;

public class ComboVo {
	
	private Integer cid;
	private String cname;
	private Integer ckc;
	
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Integer getCkc() {
		return ckc;
	}
	public void setCkc(Integer ckc) {
		this.ckc = ckc;
	}
	
	
	@Override
	public String toString() {
		return "ComboVo [cid=" + cid + ", cname=" + cname + ", ckc=" + ckc
				+ "]";
	}
	
	

}
