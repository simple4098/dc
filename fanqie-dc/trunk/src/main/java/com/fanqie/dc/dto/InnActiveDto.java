package com.fanqie.dc.dto;

import com.fanqie.dc.domain.InnActive;
import java.util.List;

/**
 * DESC : 活跃客栈报表
 * @author : 番茄木-ZLin
 * @data : 2015/5/20
 * @version: v1.0.0
 */
public class InnActiveDto extends InnActive {

    //订单数
    private String orderNumList;
    //入住数
    private String checkInNumList;
    //退房数
    private String checkOutNumList;
    //操作数
    private String operateNumList;
    public List<Integer> activeList;
    private String  createDates;

    public String getCreateDates() {
        return createDates;
    }

    public void setCreateDates(String createDates) {
        this.createDates = createDates;
    }

    public String getOrderNumList() {
        return orderNumList;
    }

    public void setOrderNumList(String orderNumList) {
        this.orderNumList = orderNumList;
    }

    public String getCheckInNumList() {
        return checkInNumList;
    }

    public void setCheckInNumList(String checkInNumList) {
        this.checkInNumList = checkInNumList;
    }

    public String getCheckOutNumList() {
        return checkOutNumList;
    }

    public void setCheckOutNumList(String checkOutNumList) {
        this.checkOutNumList = checkOutNumList;
    }

    public String getOperateNumList() {
        return operateNumList;
    }

    public void setOperateNumList(String operateNumList) {
        this.operateNumList = operateNumList;
    }

    public List<Integer> getActiveList() {
        return activeList;
    }

    public void setActiveList(List<Integer> activeList) {
        this.activeList = activeList;
    }
}
