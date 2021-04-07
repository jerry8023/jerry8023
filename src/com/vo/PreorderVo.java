package com.vo;

public class PreorderVo {
	
	private Integer poid;
	private String bjid;
	private Integer oid;
	private String poname;
	private String phone;
	//private Integer state;
	private java.sql.Timestamp podate;
	private java.sql.Timestamp ydsj;
	private java.sql.Timestamp blsj;
	private String remarks;
	
	
	public Integer getPoid() {
		return poid;
	}
	public void setPoid(Integer poid) {
		this.poid = poid;
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
	public String getPoname() {
		return poname;
	}
	public void setPoname(String poname) {
		this.poname = poname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/*public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}*/
	public java.sql.Timestamp getPodate() {
		return podate;
	}
	public void setPodate(java.sql.Timestamp podate) {
		this.podate = podate;
	}
	public java.sql.Timestamp getYdsj() {
		return ydsj;
	}
	public void setYdsj(java.sql.Timestamp ydsj) {
		this.ydsj = ydsj;
	}
	public java.sql.Timestamp getBlsj() {
		return blsj;
	}
	public void setBlsj(java.sql.Timestamp blsj) {
		this.blsj = blsj;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
	@Override
	public String toString() {
		return "PreorderVo [poid=" + poid + ", bjid=" + bjid + ", oid=" + oid
				+ ", poname=" + poname + ", phone=" + phone + ", podate=" + podate + ", ydsj=" + ydsj + ", blsj="
				+ blsj + ", remarks=" + remarks + "]";
	}
	

}
