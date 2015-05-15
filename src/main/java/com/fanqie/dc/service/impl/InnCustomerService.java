package com.fanqie.dc.service.impl;

import com.fanqie.dc.dao.IInnCustomerPmsDao;
import com.fanqie.dc.dao.impl.InnCustomerDcDao;
import com.fanqie.dc.domain.InnCustomer;
import com.fanqie.dc.service.IInnActiveService;
import com.fanqie.dc.service.IInnCustomerService;
import com.fanqie.dc.support.util.DcUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/14
 * @version: v1.0.0
 */
@Service
public class InnCustomerService implements IInnCustomerService {
    @Autowired
    private IInnCustomerPmsDao innCustomerPmsDao;
    @Autowired
    private InnCustomerDcDao innCustomerDcDao;
    @Override
    public List<InnCustomer> findInnCustomerByDate(String from, String to) {
        return innCustomerPmsDao.findInnCustomer(from,to);
    }

    @Override
    public void saveInnCustomer(List<InnCustomer> list) {
        if (!CollectionUtils.isEmpty(list)){
            for (InnCustomer customer:list){
                DcUtil.innCustomerCityAndProvince(customer);
            }
            innCustomerDcDao.saveInnCustomer(list);
        }

    }
}
