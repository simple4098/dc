package com.fanqie.dc.dao;

import com.fanqie.dc.dao.base.IBasePmsDao;
import com.fanqie.dc.domain.InnCustomer;

import java.util.List;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/14
 * @version: v1.0.0
 */
public interface IInnCustomerPmsDao extends IBasePmsDao<InnCustomer> {

    List<InnCustomer> findInnCustomer(String from,String to);
}
