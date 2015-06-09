package com.fanqie.dc.dao;

import com.fanqie.dc.dao.base.IBaseDcDao;
import com.fanqie.core.domain.OrderSource;
import com.fanqie.core.dto.OrderSourceDto;
import com.fanqie.core.dto.ParamDto;

import java.util.Date;
import java.util.List;
/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2015/5/15
 * @version: v1.0.0
 */
public interface IOrderSourceDcDao extends IBaseDcDao<OrderSource> {


   void  saveOrderSource(List<OrderSource> list);

   List<OrderSource> findDcOrderSource(ParamDto paramDto);

   OrderSourceDto findDcOrderSourceNum(ParamDto paramDto);
}
