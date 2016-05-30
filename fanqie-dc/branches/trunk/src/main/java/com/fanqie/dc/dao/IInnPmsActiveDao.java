package com.fanqie.dc.dao;

import com.fanqie.core.domain.InnActive;
import com.fanqie.dc.dao.base.IBaseDao;

import java.util.List;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/12
 * @version: v1.0.0
 */
public interface IInnPmsActiveDao extends IBaseDao<InnActive> {
    List<InnActive> findDayInnActive(String startDate,String endDate);
}
