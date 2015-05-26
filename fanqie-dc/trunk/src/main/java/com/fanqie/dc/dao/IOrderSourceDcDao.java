package com.fanqie.dc.dao;

import com.fanqie.dc.dao.base.IBaseDcDao;
import com.fanqie.dc.domain.OrderSource;
import com.fanqie.dc.dto.OrderSourceDto;
import com.fanqie.dc.dto.ParamDto;

import java.util.Date;
import java.util.List;
/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2015/5/15
 * @version: v1.0.0
 */
public interface IOrderSourceDcDao extends IBaseDcDao<OrderSource> {


   void  saveOrderSource(List<OrderSource> list,Date date);

   List<OrderSource> findDcOrderSource(ParamDto paramDto);

   OrderSourceDto findDcOrderSourceNum(ParamDto paramDto);
}
