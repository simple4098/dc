package com.fanqie.dc.dao;

import com.fanqie.dc.dao.base.IBasePmsDao;
import com.fanqie.dc.domain.OperateTrend;

import java.util.List;

/**
 * DESC : pms查询 客栈的运营情况
 * @author : 番茄木-ZLin
 * @data : 2015/5/13
 * @version: v1.0.0
 */
public interface IOperateTrendPmsDao extends IBasePmsDao<OperateTrend> {

    List<OperateTrend> findOperateDataByDate(String toDate);

}
