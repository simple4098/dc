package com.fanqie.dc.service.impl;


import com.fanqie.dc.dao.IIPPmsDao;
import com.fanqie.dc.domain.IPEntity;
import com.fanqie.dc.service.IIPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2015/4/22
 * @version: v1.0.0
 */
@Service
public class IPServiceImpl implements IIPService {
    @Autowired
    private IIPPmsDao ipDao;

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED,readOnly =false)
    public void saveIP() throws Exception {

    }

    @Override
    public  List<IPEntity> findValidIp(String type,String limit) {
        Integer limitInt = null;
        if (limit!=null){
            limitInt = Integer.parseInt(limit);
            if (limitInt>20){
                limitInt = 20;
            }
        }
        return  ipDao.findValidIp(type,limitInt);
    }
}
