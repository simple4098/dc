package com.fanqie.dc.service.impl;

import com.fanqie.dc.dao.IOrderSourceDcDao;
import com.fanqie.dc.dao.IOrderSourcePmsDao;
import com.fanqie.core.domain.OrderSource;
import com.fanqie.core.dto.OrderSourceDto;
import com.fanqie.core.dto.ParamDto;
import com.fanqie.dc.service.IOrderSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/15
 * @version: v1.0.0
 */
@Service
public class OrderSourceService implements IOrderSourceService {

    @Autowired
    private IOrderSourcePmsDao orderSourcePmsDao;
    @Autowired
    private IOrderSourceDcDao orderSourceDcDao;

    @Override
    public List<OrderSource> findOrderSource(String from, String to) {
        return orderSourcePmsDao.findOrderSource(from,to);
    }

    @Override
    public void saveOrderSource(List<OrderSource> list,Date date) {
        orderSourceDcDao.saveOrderSource(list,date);
    }

    @Override
    public List<OrderSource> findDcOrderSource(ParamDto paramDto) {
        return orderSourceDcDao.findDcOrderSource(paramDto);
    }

    @Override
    public OrderSourceDto findDcOrderSourceNum(ParamDto paramDto) {
        return orderSourceDcDao.findDcOrderSourceNum(paramDto);
    }
}
