package com.fanqie.dc.service.impl;

import com.fanqie.dc.dao.IInnDcActiveDao;
import com.fanqie.dc.dao.IInnPmsActiveDao;
import com.fanqie.dc.domain.InnActive;
import com.fanqie.dc.service.IInnActiveService;
import com.fanqie.util.DateUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2015/5/12
 * @version: v1.0.0
 */
@Service
public class InnActiveService implements IInnActiveService {
    @Autowired
    private IInnPmsActiveDao innPmsActiveDao;
    @Autowired
    private IInnDcActiveDao innDcActiveDao;

    @Override
    public List<InnActive> findDayInnActive(String startDate, String endDate) {
        return innPmsActiveDao.findDayInnActive(startDate,endDate);
    }

    @Override
    public void saveInnActive(List<InnActive> innActive,String from) {
        if (!CollectionUtils.isEmpty(innActive)){
           // Date now = DateUtil.addDay(new Date(), -1);
            Date date = DateUtil.parseDate(from);
            innDcActiveDao.saveInnActive(innActive,date);
        }

    }
}
