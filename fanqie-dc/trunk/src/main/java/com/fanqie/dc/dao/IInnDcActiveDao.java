package com.fanqie.dc.dao;

import com.fanqie.dc.dao.base.IBaseDcDao;
import com.fanqie.core.domain.InnActive;
import com.fanqie.core.dto.InnActiveDto;
import com.fanqie.core.dto.ParamDto;
import com.fanqie.util.Pagination;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/12
 * @version: v1.0.0
 */
public interface IInnDcActiveDao extends IBaseDcDao<InnActive> {
    void saveInnActive(List<InnActive> list,Date now);

    Map<String, Object> findDcInnActivePage(ParamDto paramDto,Pagination pagination);
}
