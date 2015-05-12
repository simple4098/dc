package com.fanqie.dc.dao.impl;

import com.fanqie.dc.dao.IInnDcActiveDao;
import com.fanqie.dc.dao.IInnPmsActiveDao;
import com.fanqie.dc.dao.base.BaseDcDaoImpl;
import com.fanqie.dc.dao.base.BasePmsDaoImpl;
import com.fanqie.dc.domain.InnActive;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2015/5/12
 * @version: v1.0.0
 */
@Repository
public class InnDcActiveDao extends BaseDcDaoImpl<InnActive> implements IInnDcActiveDao {
     private final static String NA = "com.fanqie.dc.domain.InnActive.";

    @Override
    public void saveInnActive(List<InnActive> list,Date now) {
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("list",list);
        param.put("now",now);
        templateDc.insert(NA.concat("saveInnActive"),param);
    }
}
