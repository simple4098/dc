package com.fanqie.dc.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/18
 * @version: v1.0.0
 */
public class OperateTrendDto {

    private List<String>  date;
    private List<BigDecimal>  income;
    private List<Integer>  roomDays;
    private List<BigDecimal>  livePercentList;
    private List<BigDecimal>  avgPriceList;

    public List<String> getDate() {
        return date;
    }

    public void setDate(List<String> date) {
        this.date = date;
    }

    public List<BigDecimal> getIncome() {
        return income;
    }

    public void setIncome(List<BigDecimal> income) {
        this.income = income;
    }

    public List<Integer> getRoomDays() {
        return roomDays;
    }

    public void setRoomDays(List<Integer> roomDays) {
        this.roomDays = roomDays;
    }

    public List<BigDecimal> getLivePercentList() {
        return livePercentList;
    }

    public void setLivePercentList(List<BigDecimal> livePercentList) {
        this.livePercentList = livePercentList;
    }

    public List<BigDecimal> getAvgPriceList() {
        return avgPriceList;
    }

    public void setAvgPriceList(List<BigDecimal> avgPriceList) {
        this.avgPriceList = avgPriceList;
    }
}
