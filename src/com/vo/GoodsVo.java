package com.vo;

public class GoodsVo {
	
	private Integer gid;
	private Integer gtid;
	private Integer oid;
	//憧危。。。。。
	private String dname;
	private String jp;
	private String dw;
	private Double price;
	private Double costs;
	private Integer stock;
	private Integer isjskc;
	private Integer warnstock;
	private Integer isdh;
	private Integer dhjf;
	private Integer jfid;
	
	
	
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Integer getGtid() {
		return gtid;
	}
	public void setGtid(Integer gtid) {
		this.gtid = gtid;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getJp() {
		return jp;
	}
	public void setJp(String jp) {
		this.jp = jp;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getCosts() {
		return costs;
	}
	public void setCosts(Double costs) {
		this.costs = costs;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getIsjskc() {
		return isjskc;
	}
	public void setIsjskc(Integer isjskc) {
		this.isjskc = isjskc;
	}
	public Integer getWarnstock() {
		return warnstock;
	}
	public void setWarnstock(Integer warnstock) {
		this.warnstock = warnstock;
	}
	public Integer getIsdh() {
		return isdh;
	}
	public void setIsdh(Integer isdh) {
		this.isdh = isdh;
	}
	public Integer getDhjf() {
		return dhjf;
	}
	public void setDhjf(Integer dhjf) {
		this.dhjf = dhjf;
	}
	
	public Integer getJfid() {
		return jfid;
	}
	public void setJfid(Integer jfid) {
		this.jfid = jfid;
	}
	
	
	@Override
	public String toString() {
		return "GoodsVo [gid=" + gid + ", gtid=" + gtid + ", oid=" + oid
				+ ", dname=" + dname + ", jp=" + jp + ", dw=" + dw + ", price="
				+ price + ", costs=" + costs + ", stock=" + stock + ", isjskc="
				+ isjskc + ", warnstock=" + warnstock + ", isdh=" + isdh
				+ ", dhjf=" + dhjf + ", jfid=" + jfid + "]";
	}
	
	
	

}
