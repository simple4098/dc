package com.fanqie.dc.dao;

import com.fanqie.core.domain.InnCustomer;
import com.fanqie.dc.dao.base.IBaseDao;

import java.util.List;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/14
 * @version: v1.0.0
 */
public interface IInnCustomerDcDao extends IBaseDao<InnCustomer> {

    void saveInnCustomer(List<InnCustomer> list);

    void saveInnCustomer(InnCustomer list);
}
