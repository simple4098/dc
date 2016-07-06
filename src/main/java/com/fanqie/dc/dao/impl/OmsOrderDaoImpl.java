package com.fanqie.dc.dao.impl;

import com.fanqie.dc.bean.RoomNightNumber;
import com.fanqie.dc.bean.order.OrderStat;
import com.fanqie.dc.bean.order.OrderStatBo;
import com.fanqie.dc.dao.IOmsOrderDao;
import com.fanqie.dc.dao.base.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * desc:
 * author:lzb
 * date:2015/9/22
 */
@Repository
public class OmsOrderDaoImpl extends BaseDaoImpl<OrderStat> implements IOmsOrderDao {

    @Override
    public List<OrderStat> getOrderStat(OrderStatBo bo) {
        return template.selectList(OMS_NS + ".getOrderStat", bo);
    }

    @Override
    public List<Integer> getExistPmsInnId(List<Integer> innIds, String from,String to) {
        Map<String,Object> map = new HashMap<>();
        map.put("from",from);
        map.put("to",to);
        map.put("innIds",innIds);
        return template.selectList(CRM_NS + ".getExistPmsInnId", map);
    }

	@Override
	public List<RoomNightNumber> getRoomNightNumber(Date nowDate) {
		Map<String,Object> map = new HashMap<>();
        map.put("nowDate", nowDate);
		return template.selectList(OMS_NS + ".getRoomNightNumber", map);
	}

	@Override
	public void addRoomNightNumberToCrm(List<RoomNightNumber> list, Date nowDate) {
		Map<String,Object> map = new HashMap<>();
        map.put("nowDate", nowDate);
        map.put("list", list);
		template.insert(CRM_NS + ".addRoomNightNumberToCrm", map);
	}

	@Override
	public void deleteCrmRoomNightNumberData(Date nowDate) {
		Map<String,Object> map = new HashMap<>();
        map.put("nowDate", nowDate);
        template.delete(CRM_NS + ".deleteCrmRoomNightNumberData", map);
	}
}
