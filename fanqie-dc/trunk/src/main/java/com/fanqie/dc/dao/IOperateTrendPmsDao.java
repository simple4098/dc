package com.fanqie.dc.dao;

import com.fanqie.core.domain.OperateTrend;
import com.fanqie.dc.dao.base.IBaseDao;

import java.util.List;

/**
 * DESC : pms查询 客栈的运营情况
 * @author : 番茄木-ZLin
 * @data : 2015/5/13
 * @version: v1.0.0
 */
public interface IOperateTrendPmsDao extends IBaseDao<OperateTrend> {

    List<OperateTrend> findOperateDataByDate(String from,String to);

}
