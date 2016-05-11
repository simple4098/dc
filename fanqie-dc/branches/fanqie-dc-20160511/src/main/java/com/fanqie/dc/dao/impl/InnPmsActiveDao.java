package com.fanqie.dc.dao.impl;

import com.fanqie.core.domain.InnActive;
import com.fanqie.dc.dao.IInnPmsActiveDao;
import com.fanqie.dc.dao.base.BaseDaoImpl;
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
public class InnPmsActiveDao extends BaseDaoImpl<InnActive> implements IInnPmsActiveDao {
     private final static String NA = "com.fanqie.dc.dao.IInnPmsActiveDao.";
    @Override
    public List<InnActive> findDayInnActive(String startDate, String endDate) {
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("startDate",startDate);
        param.put("endDate",endDate);
        return template.selectList(NA.concat("findDayInnActive"),param);
    }
}
