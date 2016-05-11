package com.fanqie.dc.dao;

import com.fanqie.core.domain.OrderSource;
import com.fanqie.dc.dao.base.IBaseDao;

import java.util.List;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/15
 * @version: v1.0.0
 */
public interface IOrderSourcePmsDao extends IBaseDao<OrderSource> {

    /**
     * 查询一段时间的 所有客栈的订单情况
     * @param from
     * @param to
     */
    List<OrderSource> findOrderSource(String from,String to);

}
