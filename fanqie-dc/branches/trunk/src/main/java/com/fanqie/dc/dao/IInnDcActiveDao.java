package com.fanqie.dc.dao;

import com.fanqie.core.domain.InnActive;
import com.fanqie.core.dto.ParamDto;
import com.fanqie.dc.dao.base.IBaseDao;
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
public interface IInnDcActiveDao extends IBaseDao<InnActive> {
    void saveInnActive(List<InnActive> list,Date now);
    void saveInnActive(InnActive list,Date now);

    Map<String, Object> findDcInnActivePage(ParamDto paramDto,Pagination pagination);
}
