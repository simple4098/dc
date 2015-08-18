package com.fanqie.dc.service;

import com.fanqie.core.domain.InnCustomer;
import com.fanqie.core.dto.InnCustomerDto;
import com.fanqie.core.dto.ParamDto;
import com.fanqie.util.Pagination;

import java.util.List;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2015/5/14
 * @version: v1.0.0
 */
public interface IInnCustomerService  {

    /**
     * pms 统计客栈的用户情况
     * @param from 开始时间
     * @param to 结束时间
     */
    List<InnCustomer> findInnCustomerByDate(String from,String to);

    /**
     * 数据中心保持客栈客户信息
     */
    void saveInnCustomer(List<InnCustomer> list);

    /**
     * 查询一段时间第三方绑定客栈的客户资料情况
     * @param paramDto
     * @param page
     * @return
     */
    List<InnCustomer> findInnCustomerByPage(ParamDto paramDto,Pagination page);

    /**
     * 查询一段时间第三方绑定客栈用户数和城市数
     * @param paramDto
     * @return
     */
    InnCustomerDto findInnCustomerNumAndCityNum(ParamDto paramDto);
}
