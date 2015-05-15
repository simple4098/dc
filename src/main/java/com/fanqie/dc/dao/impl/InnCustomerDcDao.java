package com.fanqie.dc.dao.impl;

import com.fanqie.dc.dao.IInnCustomerDcDao;
import com.fanqie.dc.dao.base.BaseDcDaoImpl;
import com.fanqie.dc.domain.InnCustomer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2015/5/14
 * @version: v1.0.0
 */
@Repository
public class InnCustomerDcDao extends BaseDcDaoImpl<InnCustomer> implements IInnCustomerDcDao {
    private static  final String NA = "com.fanqie.dc.dao.IInnCustomerDcDao.";


    @Override
    public void saveInnCustomer(List<InnCustomer> list) {
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("list",list);
        this.templateDc.insert(NA.concat("saveInnCustomer"),param);
    }
}
