package com.fanqie.dc.dao.impl;

import com.fanqie.core.domain.OperateTrend;
import com.fanqie.core.dto.ParamDto;
import com.fanqie.dc.dao.IOperateTrendDcDao;
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
public class OperateTrendDcDao extends BaseDaoImpl<OperateTrend> implements IOperateTrendDcDao {
    private static  final  String NA = "com.fanqie.dc.dao.IOperateTrendDcDao.";


    @Override
    public void saveOperateTrend(List<OperateTrend> list) {
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("list",list);
        this.template.insert(NA.concat("saveOperateTrend"),param);
    }

    @Override
    public OperateTrend obtGeneralOperateTrend(ParamDto paramDto) {
        return (OperateTrend)template.selectOne(NA.concat("obtGeneralOperateTrend"),paramDto);
    }

    @Override
    public List<OperateTrend> obtOpeDetail(ParamDto paramDto) {
        return template.selectList(NA.concat("obtOpeDetail"),paramDto);
    }

    @Override
    public void saveOperateTrend(OperateTrend operateTrend) {
        this.template.insert(NA.concat("saveOperate"),operateTrend);
    }
}
