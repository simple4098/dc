package com.fanqie.dc.dao.impl;

import com.fanqie.core.domain.InnActive;
import com.fanqie.core.dto.ParamDto;
import com.fanqie.dc.dao.IInnDcActiveDao;
import com.fanqie.dc.dao.base.BaseDaoImpl;
import com.fanqie.util.Pagination;
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
public class InnDcActiveDao extends BaseDaoImpl<InnActive> implements IInnDcActiveDao {
     private final static String NA = "com.fanqie.dc.domain.InnActive.";

    @Override
    public void saveInnActive(List<InnActive> list,Date now) {
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("list",list);
        param.put("now",now);
        template.insert(NA.concat("saveInnActiveList"), param);
    }
    @Override
    public void saveInnActive(InnActive active,Date now) {
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("o",active);
        param.put("now",now);
        template.insert(NA.concat("saveInnActive"),param);
    }

    @Override
    public  Map<String, Object> findDcInnActivePage(ParamDto paramDto,Pagination pagination) {
        Map<String, Object> map = queryByPage(paramDto, pagination, NA.concat("findDcInnActive"));
        return map;

    }
}
