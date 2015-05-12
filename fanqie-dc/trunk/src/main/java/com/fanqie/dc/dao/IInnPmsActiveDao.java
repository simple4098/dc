package com.fanqie.dc.dao;

import com.fanqie.dc.dao.base.IBasePmsDao;
import com.fanqie.dc.domain.InnActive;

import java.util.List;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/12
 * @version: v1.0.0
 */
public interface IInnPmsActiveDao extends IBasePmsDao<InnActive> {
    List<InnActive> findDayInnActive(String startDate,String endDate);
}
