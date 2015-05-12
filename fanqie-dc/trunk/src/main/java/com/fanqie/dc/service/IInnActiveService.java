package com.fanqie.dc.service;

import com.fanqie.dc.domain.InnActive;

import java.util.List;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/12
 * @version: v1.0.0
 */
public interface IInnActiveService {
    List<InnActive> findDayInnActive(String startDate,String endDate);

    void saveInnActive(List<InnActive> innActive);
}
