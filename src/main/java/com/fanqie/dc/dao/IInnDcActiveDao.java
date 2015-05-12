package com.fanqie.dc.dao;

import com.fanqie.dc.dao.base.IBaseDcDao;
import com.fanqie.dc.domain.InnActive;

import java.util.Date;
import java.util.List;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/12
 * @version: v1.0.0
 */
public interface IInnDcActiveDao extends IBaseDcDao<InnActive> {
    void saveInnActive(List<InnActive> list,Date now);
}
