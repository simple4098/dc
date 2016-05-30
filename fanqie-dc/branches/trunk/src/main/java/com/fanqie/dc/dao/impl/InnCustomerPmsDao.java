package com.fanqie.dc.dao.impl;

import com.fanqie.core.domain.InnCustomer;
import com.fanqie.dc.dao.IInnCustomerPmsDao;
import com.fanqie.dc.dao.base.BaseDaoImpl;
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
public class InnCustomerPmsDao extends BaseDaoImpl<InnCustomer> implements IInnCustomerPmsDao {
    private static  final String NA = "com.fanqie.dc.dao.IInnCustomerPmsDao.";

    @Override
    public List<InnCustomer> findInnCustomer(String from, String to) {
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("startDate",from);
        param.put("endDate",to);
        return template.selectList(NA.concat("findInnCustomer"),param);
    }
}
