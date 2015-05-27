package com.fanqie.dc.dao;

import com.fanqie.dc.dao.base.IBasePmsDao;
import com.fanqie.core.domain.OrderSource;

import java.util.List;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/15
 * @version: v1.0.0
 */
public interface IOrderSourcePmsDao extends IBasePmsDao<OrderSource>{

    /**
     * 查询一段时间的 所有客栈的订单情况
     * @param from
     * @param to
     */
    List<OrderSource> findOrderSource(String from,String to);

}
