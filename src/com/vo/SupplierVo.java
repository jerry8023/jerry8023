package com.vo;

public class SupplierVo {
	
	private Integer sid;
	private String sname;
	private String sjc;
	private String contact;
	private Integer phone;
	private String address;
	private Integer ismr;
	private String remarks;
	
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSjc() {
		return sjc;
	}
	public void setSjc(String sjc) {
		this.sjc = sjc;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getIsmr() {
		return ismr;
	}
	public void setIsmr(Integer ismr) {
		this.ismr = ismr;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	@Override
	public String toString() {
		return "SupplierDao [sid=" + sid + ", sname=" + sname + ", sjc=" + sjc
				+ ", contact=" + contact + ", phone=" + phone + ", address="
				+ address + ", ismr=" + ismr + ", remarks=" + remarks + "]";
	}
	
	
	
	

}
