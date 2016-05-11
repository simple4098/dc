package com.fanqie.dc.dao.impl;

import com.fanqie.core.domain.OperateTrend;
import com.fanqie.dc.dao.IOperateTrendPmsDao;
import com.fanqie.dc.dao.base.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/13
 * @version: v1.0.0
 */
@Repository
public class OperateTrendPmsDao extends BaseDaoImpl<OperateTrend> implements IOperateTrendPmsDao {
    private static  final  String NA = "com.fanqie.dc.dao.IOperateTrendPmsDao.";

    @Override
    public List<OperateTrend> findOperateDataByDate(String from,String to) {
        Map<String,Object> param = new HashMap<>();
        param.put("from",from);
        param.put("to",to);
        return this.template.selectList(NA.concat("findOperateDataByDate"),param);
    }
}
