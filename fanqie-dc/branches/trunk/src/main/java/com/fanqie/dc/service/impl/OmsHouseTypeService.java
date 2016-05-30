package com.fanqie.dc.service.impl;

import com.fanqie.dc.bean.HouseTypeNumber;
import com.fanqie.dc.dao.IOmsHouseTypeNumberDao;
import com.fanqie.dc.dao.dynamic.DataSource;
import com.fanqie.dc.service.IOmsHouseTypeService;
import com.fanqie.dc.support.util.CommonUtil;
import com.fanqie.dc.support.util.JodaTimeUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OmsHouseTypeService implements IOmsHouseTypeService {
	
	@Autowired
	IOmsHouseTypeNumberDao houseTypeNumberDao;
	Logger logger=Logger.getLogger(OmsHouseTypeService.class);
    
	@DataSource(name = DataSource.OMS)
	@Override
	public List<HouseTypeNumber> getHouseTypeNumber(){
		//统计可卖房型数量数据
		List<HouseTypeNumber> list;
		list = houseTypeNumberDao.getHouseTypeNumber();
		//给可卖房型数量数据添加记录日期
		Date now=new Date();
		String from=JodaTimeUtil.format(now)+" 00:00:00";
		for (HouseTypeNumber houseTypeNumber : list) {
			houseTypeNumber.setCreatedAt(from);
		}
		return list;
	}
	
	@DataSource(name = DataSource.CRM)
	@Override
	public Map<String, Object> addToOms(List<HouseTypeNumber> houseType) {
		Map<String, Object> result=new HashMap<>();
		Map<String,List<HouseTypeNumber>> map=new HashMap<>();
		map.put("houseTypeNumberList", houseType);
		//删除统计之前的所有可卖房型数量数据
		houseTypeNumberDao.deleteAllData();
		try {
			//添加当天可卖房型数量新数据
			houseTypeNumberDao.saveAll(map,houseTypeNumberDao.CRM_NS);
		} catch (Exception e) {
            e.printStackTrace();
			logger.debug("添加当天可卖房型数量新数据出错！",e);
			CommonUtil.setErrorInfo(result, e.getMessage());
		}
		CommonUtil.setSuccessInfo(result);
		return result;
	}

}
