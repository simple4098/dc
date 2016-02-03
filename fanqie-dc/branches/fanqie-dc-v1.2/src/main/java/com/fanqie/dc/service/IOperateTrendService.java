package com.fanqie.dc.service;

import com.fanqie.core.domain.OperateTrend;
import com.fanqie.core.dto.OperateTrendDto;
import com.fanqie.core.dto.ParamDto;

import java.util.List;
import java.util.Map;

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
     * @param form 开始时间
     * @param to 结束时间
     */
    List<OperateTrend> findOperateTrendService(String form,String to);

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
    Map<String,Object> obtOpeDetail(ParamDto paramDto);
}
