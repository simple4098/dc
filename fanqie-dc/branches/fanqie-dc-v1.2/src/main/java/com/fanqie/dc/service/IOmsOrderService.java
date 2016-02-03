package com.fanqie.dc.service;

import com.fanqie.dc.bean.order.OrderStat;
import com.fanqie.dc.bean.order.OrderStatBo;

import java.util.List;
import java.util.Map;

/**
 * desc:
 * author:lzb
 * date:2015/9/22
 */
public interface IOmsOrderService {

    List<OrderStat> getOrderStat(OrderStatBo bo);

    Map<String,Object> updateToOms(List<OrderStat> list,OrderStatBo bo);
}
