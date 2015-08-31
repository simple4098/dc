package com.fanqie.dc.service;

import com.fanqie.core.domain.InnActive;
import com.fanqie.core.dto.InnActiveDto;
import com.fanqie.core.dto.ParamDto;
import com.fanqie.util.Pagination;

import java.util.List;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2015/5/12
 * @version: v1.0.0
 */
public interface IInnActiveService {
    List<InnActive> findDayInnActive(String startDate,String endDate);

    void saveInnActive(List<InnActive> innActive,String form);

    /**
     * 第三方系统 客栈活跃报表
     * @param paramDto 查询查询
     */
    List<InnActiveDto> findDcInnActive(ParamDto paramDto,Pagination pagination);
}
