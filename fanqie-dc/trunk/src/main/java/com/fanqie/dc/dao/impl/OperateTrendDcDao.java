package com.fanqie.dc.dao.impl;

import com.fanqie.dc.dao.IOperateTrendDcDao;
import com.fanqie.dc.dao.base.BaseDcDaoImpl;
import com.fanqie.core.domain.OperateTrend;
import com.fanqie.core.dto.OperateTrendDto;
import com.fanqie.core.dto.ParamDto;
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
public class OperateTrendDcDao extends BaseDcDaoImpl<OperateTrend> implements IOperateTrendDcDao {
    private static  final  String NA = "com.fanqie.dc.dao.IOperateTrendDcDao.";


    @Override
    public void saveOperateTrend(List<OperateTrend> list) {
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("list",list);
        this.templateDc.insert(NA.concat("saveOperateTrend"),param);
    }

    @Override
    public OperateTrend obtGeneralOperateTrend(ParamDto paramDto) {
        return (OperateTrend)templateDc.selectOne(NA.concat("obtGeneralOperateTrend"),paramDto);
    }

    @Override
    public List<OperateTrend> obtOpeDetail(ParamDto paramDto) {
        return templateDc.selectList(NA.concat("obtOpeDetail"),paramDto);
    }
}
