package com.fanqie.dc.dao.impl;

import com.fanqie.core.domain.OrderSource;
import com.fanqie.core.dto.OrderSourceDto;
import com.fanqie.core.dto.ParamDto;
import com.fanqie.dc.dao.IOrderSourceDcDao;
import com.fanqie.dc.dao.base.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/15
 * @version: v1.0.0
 */
@Repository
public class OrderSourceDcDao extends BaseDaoImpl<OrderSource> implements IOrderSourceDcDao {
    private static final  String NA ="com.fanqie.dc.dao.IOrderSourceDcDao.";


    @Override
    public void saveOrderSource(List<OrderSource> list) {
        template.insert(NA.concat("saveOrderSource"),list);
    }

    @Override
    public List<OrderSource> findDcOrderSource(ParamDto paramDto) {
        return template.selectList(NA.concat("findDcOrderSource"),paramDto);
    }

    @Override
    public OrderSourceDto findDcOrderSourceNum(ParamDto paramDto) {
        return template.selectOne(NA.concat("findOrderSourceNum"),paramDto);
    }

    @Override
    public void saveOrderSource(OrderSource orderSource) {
        template.insert(NA.concat("saveOrder"),orderSource);
    }
}
