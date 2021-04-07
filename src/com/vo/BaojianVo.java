package com.vo;

public class BaojianVo implements Comparable<BaojianVo>{
	
	private String bjid;
	private String bjname;
	private Integer bjtid;
	private Integer state;
	private String area;
	private BaojiantypeVo baoJianType;
	
	
	public String getBjid() {
		return bjid;
	}
	public void setBjid(String bjid) {
		this.bjid = bjid;
	}
	public Integer getBjtid() {
		return bjtid;
	}
	public void setBjtid(Integer bjtid) {
		this.bjtid = bjtid;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	
	
	public BaojiantypeVo getBaoJianType() {
		return baoJianType;
	}
	public void setBaoJianType(BaojiantypeVo baoJianType) {
		this.baoJianType = baoJianType;
	}
	
	
	
	public String getBjname() {
		return bjname;
	}
	
	
	public void setBjname(String bjname) {
		this.bjname = bjname;
	}
	
	
	
	@Override
	public String toString() {
		return "BaojianVo [bjid=" + bjid + ", bjtid=" + bjtid + ", state="
				+ state + ", area=" + area + "]";
	}
	
	@Override
	public int compareTo(BaojianVo o) {
		int val=this.bjid.compareTo(o.getBjid());
		return val;
	}
	
	

}
