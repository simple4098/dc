package com.fanqie.dc.bean;

public class HouseTypeNumber {
	
	private Integer pmsInnId;
	private Integer houseTypeNumber;//可卖房型数量
	private String createdAt;//创建记录的日期
	
	public Integer getPmsInnId() {
		return pmsInnId;
	}
	public void setPmsInnId(Integer pmsInnId) {
		this.pmsInnId = pmsInnId;
	}
	public Integer getHouseTypeNumber() {
		return houseTypeNumber;
	}
	public void setHouseTypeNumber(Integer houseTypeNumber) {
		this.houseTypeNumber = houseTypeNumber;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
}
