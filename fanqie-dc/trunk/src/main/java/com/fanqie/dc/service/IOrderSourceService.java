package com.fanqie.dc.service;

import com.fanqie.dc.domain.OrderSource;
import com.fanqie.dc.dto.OrderSourceDto;
import com.fanqie.dc.dto.ParamDto;

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

    /**
     * 给第三方提供某一个客栈的订单情况接口
     * @param paramDto 查询条件
     */
    List<OrderSource> findDcOrderSource(ParamDto paramDto);

    /**
     * 查询订单概要信息  总收入 实住间夜数  ....
     * @param paramDto
     * @return
     */
    OrderSourceDto findDcOrderSourceNum(ParamDto paramDto);
}
