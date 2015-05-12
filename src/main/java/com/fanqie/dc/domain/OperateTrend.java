package com.fanqie.dc.domain;

import com.fanqie.core.Domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * DESC : 运营趋势
 * @author : 番茄木-ZLin
 * @data : 2015/5/12
 * @version: v1.0.0
 */
public class OperateTrend extends Domain{
    //客栈id
    private  Integer innId;
    //营业收入
    private BigDecimal totalIncome;
    //总的房间数
    private int totalRoomNum;
    //实住数
    private int realLiveNum;
    //空置房间数
    private int emptyRoomNum;
    //均价
    private BigDecimal avgPrice;
    //入住率
    private BigDecimal livePercent;
    //客栈账号
    private String innCode;
    //客栈名称
    private String innName;
    //客栈联系电话
    private String mobile;


    public Integer getInnId() {
        return innId;
    }

    public void setInnId(Integer innId) {
        this.innId = innId;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public int getTotalRoomNum() {
        return totalRoomNum;
    }

    public void setTotalRoomNum(int totalRoomNum) {
        this.totalRoomNum = totalRoomNum;
    }

    public int getRealLiveNum() {
        return realLiveNum;
    }

    public void setRealLiveNum(int realLiveNum) {
        this.realLiveNum = realLiveNum;
    }

    public int getEmptyRoomNum() {
        return emptyRoomNum;
    }

    public void setEmptyRoomNum(int emptyRoomNum) {
        this.emptyRoomNum = emptyRoomNum;
    }

    public BigDecimal getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(BigDecimal avgPrice) {
        this.avgPrice = avgPrice;
    }

    public BigDecimal getLivePercent() {
        return livePercent;
    }

    public void setLivePercent(BigDecimal livePercent) {
        this.livePercent = livePercent;
    }

    public String getInnCode() {
        return innCode;
    }

    public void setInnCode(String innCode) {
        this.innCode = innCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }



    public String getInnName() {
        return innName;
    }

    public void setInnName(String innName) {
        this.innName = innName;
    }
}
