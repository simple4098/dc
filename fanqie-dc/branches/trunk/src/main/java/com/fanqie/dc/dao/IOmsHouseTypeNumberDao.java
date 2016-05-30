package com.fanqie.dc.dao;

import com.fanqie.dc.bean.HouseTypeNumber;
import com.fanqie.dc.dao.base.IBaseDao;

import java.util.List;

public interface IOmsHouseTypeNumberDao extends IBaseDao<HouseTypeNumber> {
	
	String OMS_NS = "com.fanqie.dc.bean.HouseTypeNumber.oms";
    String CRM_NS = "com.fanqie.dc.bean.HouseTypeNumber";
    
    /**
     * oms库
     * @return
     */
    List<HouseTypeNumber> getHouseTypeNumber();

    /**
     * crm库
     * 删除统计之前的所有可卖房型数量数据
     */
    void deleteAllData();
}
