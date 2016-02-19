package com.fanqie.dc.service;

import java.util.List;
import java.util.Map;

import com.fanqie.dc.bean.HouseTypeNumber;

public interface IOmsHouseTypeService {

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
}
