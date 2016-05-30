package com.fanqie.dc.dao;

import com.fanqie.core.domain.OperateTrend;
import com.fanqie.core.dto.ParamDto;
import com.fanqie.dc.dao.base.IBaseDao;

import java.util.List;

/**
 * DESC : pms查询 客栈的运营情况
 * @author : 番茄木-ZLin
 * @data : 2015/5/13
 * @version: v1.0.0
 */
public interface IOperateTrendDcDao extends IBaseDao<OperateTrend> {
    /**
     * 保存运营数据
     * @param list
     */
    void saveOperateTrend(List<OperateTrend> list);

    OperateTrend obtGeneralOperateTrend(ParamDto paramDto);

    List<OperateTrend> obtOpeDetail(ParamDto paramDto);

    void saveOperateTrend(OperateTrend o);
}
