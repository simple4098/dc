package com.fanqie.dc.dao.impl;

import com.fanqie.dc.dao.IOrderSourcePmsDao;
import com.fanqie.dc.dao.base.BasePmsDaoImpl;
import com.fanqie.core.domain.OrderSource;
import org.springframework.stereotype.Repository;

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
public class OrderSourcePmsDao extends BasePmsDaoImpl<OrderSource> implements IOrderSourcePmsDao{
    private static final  String NA ="com.fanqie.dc.dao.IOrderSourcePmsDao.";

    @Override
    public List<OrderSource> findOrderSource(String from, String to) {
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("from",from);
        param.put("to",to);
        return templatePms.selectList(NA.concat("findOrderSource"),param);
    }
}
