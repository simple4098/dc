package com.fanqie.dc.dao.impl;

import com.fanqie.dc.bean.HouseTypeNumber;
import com.fanqie.dc.dao.IOmsHouseTypeNumberDao;
import com.fanqie.dc.dao.base.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OmsHouseTypeNumberDao extends BaseDaoImpl<HouseTypeNumber> implements IOmsHouseTypeNumberDao {

	@Override
	public List<HouseTypeNumber> getHouseTypeNumber() {
		return template.selectList(OMS_NS+".queryNumber");
	}

	@Override
	public void deleteAllData() {
		template.delete(CRM_NS+".deleteAllData");
	}

}
