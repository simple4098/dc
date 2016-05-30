package com.fanqie.dc.bean.order;

import java.sql.Timestamp;

/**
 * desc:订单统计类
 * author:lzb
 * date:2015/9/22
 */
public class OrderStat {

    private Integer id;
    private Integer pmsInnId;//pms客栈id
    private Integer crmInnId;//crm客栈id

    private Integer checkInOrderNum; //当月入住的订单数量
    private Double checkInOrderPrice;//当月入住订单的总金额
    private Integer checkInNightsNum;//当月入住订单间夜数

    private Integer checkOutOrderNum;//当月离店的订单数量
    private Double checkOutOrderPrice;//当月离店的订单总金额
    private Integer checkOutNightsNum;//当月离店订单间夜数

    private Timestamp monthTime;//当前月份

    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPmsInnId() {
        return pmsInnId;
    }

    public void setPmsInnId(Integer pmsInnId) {
        this.pmsInnId = pmsInnId;
    }

    public Integer getCrmInnId() {
        return crmInnId;
    }

    public void setCrmInnId(Integer crmInnId) {
        this.crmInnId = crmInnId;
    }

    public Integer getCheckInOrderNum() {
        return checkInOrderNum;
    }

    public void setCheckInOrderNum(Integer checkInOrderNum) {
        this.checkInOrderNum = checkInOrderNum;
    }

    public Double getCheckInOrderPrice() {
        return checkInOrderPrice;
    }

    public void setCheckInOrderPrice(Double checkInOrderPrice) {
        this.checkInOrderPrice = checkInOrderPrice;
    }

    public Integer getCheckInNightsNum() {
        return checkInNightsNum;
    }

    public void setCheckInNightsNum(Integer checkInNightsNum) {
        this.checkInNightsNum = checkInNightsNum;
    }

    public Integer getCheckOutOrderNum() {
        return checkOutOrderNum;
    }

    public void setCheckOutOrderNum(Integer checkOutOrderNum) {
        this.checkOutOrderNum = checkOutOrderNum;
    }

    public Double getCheckOutOrderPrice() {
        return checkOutOrderPrice;
    }

    public void setCheckOutOrderPrice(Double checkOutOrderPrice) {
        this.checkOutOrderPrice = checkOutOrderPrice;
    }

    public Integer getCheckOutNightsNum() {
        return checkOutNightsNum;
    }

    public void setCheckOutNightsNum(Integer checkOutNightsNum) {
        this.checkOutNightsNum = checkOutNightsNum;
    }

    public Timestamp getMonthTime() {
        return monthTime;
    }

    public void setMonthTime(Timestamp monthTime) {
        this.monthTime = monthTime;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
