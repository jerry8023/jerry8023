package com.vo;

public class OperatorVo {
	
	private Integer oid;
	private Integer rid;
	private String oname;
	private String nickname;
	private Integer password;
	private Double qdje;
	private Integer state;
	
	
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getPassword() {
		return password;
	}
	public void setPassword(Integer password) {
		this.password = password;
	}
	public Double getQdje() {
		return qdje;
	}
	public void setQdje(Double qdje) {
		this.qdje = qdje;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	
	@Override
	public String toString() {
		return "Operator [oid=" + oid + ", rid=" + rid + ", oname=" + oname
				+ ", nickname=" + nickname + ", password=" + password
				+ ", qdje=" + qdje + ", state=" + state + "]";
	}
	
	
	

}
