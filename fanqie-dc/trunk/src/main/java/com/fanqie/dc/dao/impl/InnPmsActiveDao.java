package com.fanqie.dc.dao.impl;

import com.fanqie.dc.dao.IInnPmsActiveDao;
import com.fanqie.dc.dao.base.BasePmsDaoImpl;
import com.fanqie.dc.domain.InnActive;
import org.springframework.stereotype.Repository;

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
public class InnPmsActiveDao extends BasePmsDaoImpl<InnActive> implements IInnPmsActiveDao {
     private final static String NA = "com.fanqie.dc.domain.InnActive.";
    @Override
    public List<InnActive> findDayInnActive(String startDate, String endDate) {
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("startDate",startDate);
        param.put("endDate",endDate);
        return templatePms.selectList(NA.concat("findDayInnActive"),param);
    }
}
