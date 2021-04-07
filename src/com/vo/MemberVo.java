package com.vo;

import java.util.Arrays;

public class MemberVo {
	
	private Integer mid;
	private Integer mgid;
	private String mname;
	private String sex;
	private String cardtype;
	private String password;
	private java.sql.Date usedate;
	private Double balance;
	private Integer jf;
	private Double sumbalance;
	private java.sql.Date birthday;
	private String phone;
	private java.sql.Date registerdate;
	private Integer state;
	private String remarks;
	private byte[] image;
	private MgradeVo mgradeVo;
	
	
	
	
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public Integer getMgid() {
		return mgid;
	}
	public void setMgid(Integer mgid) {
		this.mgid = mgid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public java.sql.Date getUsedate() {
		return usedate;
	}
	public void setUsedate(java.sql.Date usedate) {
		this.usedate = usedate;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Integer getJf() {
		return jf;
	}
	public void setJf(Integer jf) {
		this.jf = jf;
	}
	public Double getSumbalance() {
		return sumbalance;
	}
	public void setSumbalance(Double sumbalance) {
		this.sumbalance = sumbalance;
	}
	public java.sql.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.sql.Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public java.sql.Date getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(java.sql.Date registerdate) {
		this.registerdate = registerdate;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	public MgradeVo getMgradeVo() {
		return mgradeVo;
	}
	public void setMgradeVo(MgradeVo mgradeVo) {
		this.mgradeVo = mgradeVo;
	}
	
	
	@Override
	public String toString() {
		return "MemberVo [mid=" + mid + ", mgid=" + mgid + ", mname=" + mname
				+ ", sex=" + sex + ", cardtype=" + cardtype + ", password="
				+ password + ", usedate=" + usedate + ", balance=" + balance
				+ ", jf=" + jf + ", sumbalance=" + sumbalance + ", birthday="
				+ birthday + ", phone=" + phone + ", registerdate="
				+ registerdate + ", state=" + state + ", remarks=" + remarks
				+ ", image=" + Arrays.toString(image) + ", mgradeVo="
				+ mgradeVo + "]";
	}
	
	

}
