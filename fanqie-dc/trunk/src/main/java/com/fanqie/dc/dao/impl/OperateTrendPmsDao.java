package com.fanqie.dc.dao.impl;

import com.fanqie.dc.dao.IOperateTrendPmsDao;
import com.fanqie.dc.dao.base.BasePmsDaoImpl;
import com.fanqie.dc.domain.OperateTrend;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/13
 * @version: v1.0.0
 */
@Repository
public class OperateTrendPmsDao extends BasePmsDaoImpl<OperateTrend> implements IOperateTrendPmsDao {
    private static  final  String NA = "com.fanqie.dc.dao.IOperateTrendPmsDao.";

    @Override
    public List<OperateTrend> findOperateDataByDate(String toDate) {
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("toDate",toDate);
        return this.templatePms.selectList(NA.concat("findOperateDataByDate"),toDate);
    }
}
