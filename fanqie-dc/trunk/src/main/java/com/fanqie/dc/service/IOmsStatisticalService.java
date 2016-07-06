package com.fanqie.dc.service;

import com.fanqie.dc.bean.HouseTypeNumber;
import com.fanqie.dc.bean.RoomNightNumber;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IOmsStatisticalService {

	/**
	 * 统计之前所有客栈的可卖房型数量
	 * @author xkj
	 * @return
	 * */
	public List<HouseTypeNumber> getHouseTypeNumber();

	/**
	 * 先删除当天客栈的可卖房型数据，后添加新数据
	 * @author xkj
	 * @return
	 * */
    public Map<String, Object> addToOms(List<HouseTypeNumber> houseType);

	/**
     * oms库 
     * 获取客栈某天的间夜数
     * @param date
     * @return
     */
	List<RoomNightNumber> getRoomNightNumber(Date nowDate);

	/**
     * crm库 
     * 添加客栈某天的间夜数
     * @param date
     * @param list 
     * @return
     */
	void addRoomNightNumberToCrm(List<RoomNightNumber> list, Date nowDate);

}
