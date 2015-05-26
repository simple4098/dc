package com.fanqie.dc.dao.impl;

import com.fanqie.dc.dao.IOrderSourceDcDao;
import com.fanqie.dc.dao.base.BaseDcDaoImpl;
import com.fanqie.dc.domain.OrderSource;
import com.fanqie.dc.dto.OrderSourceDto;
import com.fanqie.dc.dto.ParamDto;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/15
 * @version: v1.0.0
 */
@Repository
public class OrderSourceDcDao extends BaseDcDaoImpl<OrderSource> implements IOrderSourceDcDao{
    private static final  String NA ="com.fanqie.dc.dao.IOrderSourceDcDao.";


    @Override
    public void saveOrderSource(List<OrderSource> list,Date date) {
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("list",list);
        param.put("date",date);
        templateDc.insert(NA.concat("saveOrderSource"),param);
    }

    @Override
    public List<OrderSource> findDcOrderSource(ParamDto paramDto) {
        return templateDc.selectList(NA.concat("findDcOrderSource"),paramDto);
    }

    @Override
    public OrderSourceDto findDcOrderSourceNum(ParamDto paramDto) {
        return templateDc.selectOne(NA.concat("findOrderSourceNum"),paramDto);
    }
}
