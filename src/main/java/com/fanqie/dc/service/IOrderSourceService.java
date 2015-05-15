package com.fanqie.dc.service;

import com.fanqie.dc.domain.OrderSource;

import java.util.Date;
import java.util.List;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/15
 * @version: v1.0.0
 */
public interface IOrderSourceService {

    List<OrderSource> findOrderSource(String from,String to);

    void  saveOrderSource(List<OrderSource> list,Date date);
}
