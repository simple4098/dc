package com.fanqie.dc.dao;

import com.fanqie.dc.bean.order.OrderStat;
import com.fanqie.dc.bean.order.OrderStatBo;
import com.fanqie.dc.dao.base.IBaseDao;

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


}
