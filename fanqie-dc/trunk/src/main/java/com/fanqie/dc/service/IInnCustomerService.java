package com.fanqie.dc.service;

import com.fanqie.dc.domain.InnCustomer;

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
}
