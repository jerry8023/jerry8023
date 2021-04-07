package com.vo;

public class HwdetailVo {
	
	private Integer hwdid;
	private Integer gid;
	private String hid;
	private Double price;
	private Integer numbers;
	
	private com.vo.HuowuVo huowuVo;
	private com.vo.GoodsVo goodVo;
	
	
	public Integer getHwdid() {
		return hwdid;
	}
	public void setHwdid(Integer hwdid) {
		this.hwdid = hwdid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Integer getNumbers() {
		return numbers;
	}
	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}
	public com.vo.HuowuVo getHuowuVo() {
		return huowuVo;
	}
	public void setHuowuVo(com.vo.HuowuVo huowuVo) {
		this.huowuVo = huowuVo;
	}
	public com.vo.GoodsVo getGoodVo() {
		return goodVo;
	}
	public void setGoodVo(com.vo.GoodsVo goodVo) {
		this.goodVo = goodVo;
	}
	
	
	
	@Override
	public String toString() {
		return "HwdetailVo [hwdid=" + hwdid + ", gid=" + gid + ", hid=" + hid
				+ ", price=" + price + ", numbers=" + numbers + ", huowuVo="
				+ huowuVo + ", goodVo=" + goodVo + "]";
	}
	
	
	

}
