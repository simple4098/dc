package com.fanqie.dc.service;

import com.fanqie.dc.domain.OperateTrend;
import com.fanqie.dc.dto.OperateTrendDto;
import com.fanqie.dc.dto.ParamDto;

import java.util.List;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/13
 * @version: v1.0.0
 */
public interface IOperateTrendService {

    /**
     * 查询pms 运营数据
     * @param date 要查询的日期
     */
    List<OperateTrend> findOperateTrendService(String date);

    /**
     * 把客栈一天的运营数据保存在数据中心
     */
    void saveOperateTrend(List<OperateTrend> list);

    /**
     * 运营情况的大致内容
     */
    OperateTrend obtGeneralOperateTrend(ParamDto paramDto);

    /**
     * 运营情况详情数据
     * @param paramDto 查询参数
     */
    OperateTrendDto obtOpeDetail(ParamDto paramDto);
}
