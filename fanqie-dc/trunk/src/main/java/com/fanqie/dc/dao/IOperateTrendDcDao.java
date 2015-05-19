package com.fanqie.dc.dao;

import com.fanqie.dc.dao.base.IBaseDcDao;
import com.fanqie.dc.dao.base.IBasePmsDao;
import com.fanqie.dc.domain.OperateTrend;
import com.fanqie.dc.dto.OperateTrendDto;
import com.fanqie.dc.dto.ParamDto;

import java.util.List;

/**
 * DESC : pms查询 客栈的运营情况
 * @author : 番茄木-ZLin
 * @data : 2015/5/13
 * @version: v1.0.0
 */
public interface IOperateTrendDcDao extends IBaseDcDao<OperateTrend> {
    /**
     * 保存运营数据
     * @param list
     */
    void saveOperateTrend(List<OperateTrend> list);

    OperateTrend obtGeneralOperateTrend(ParamDto paramDto);
}
