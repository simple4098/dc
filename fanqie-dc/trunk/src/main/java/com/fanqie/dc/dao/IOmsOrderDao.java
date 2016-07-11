package com.fanqie.dc.dao;

import com.fanqie.dc.bean.RoomNightNumber;
import com.fanqie.dc.bean.order.OrderStat;
import com.fanqie.dc.bean.order.OrderStatBo;
import com.fanqie.dc.dao.base.IBaseDao;

import java.util.Date;
import java.util.List;

/**
 * desc:处理oms渠道订单相关
 * author:lzb
 * date:2015/9/22
 */
public interface IOmsOrderDao extends IBaseDao<OrderStat>{

    String OMS_NS = "com.fanqie.dc.bean.order.OrderStat.oms";
    String CRM_NS = "com.fanqie.dc.bean.order.OrderStat.crm";

    /**
     * oms库
     * @param bo
     * @return
     */
    List<OrderStat> getOrderStat(OrderStatBo bo);

    /**
     * crm库
     * 查询在某月存在的pmsInnIds
     * @return
     */
    List<Integer> getExistPmsInnId(List<Integer> innIds,String from,String to);

    /**
     * oms库 
     * 获取客栈某天的间夜数
     * @param nowDate
     * @return
     */
	List<RoomNightNumber> getRoomNightNumber(String nowDate);

	/**
	 * crm库
	 * 记录客栈某天的间夜数
	 * @param list
	 * @param nowDate 记录间夜数的时间
	 * */
	void addRoomNightNumberToCrm(List<RoomNightNumber> list, Date nowDate);
	
	/**
	 * crm库
	 * 删除当天的客栈间夜数据
	 * @param nowDate 记录间夜数的时间
	 * */
	void deleteCrmRoomNightNumberData(Date nowDate);
}
