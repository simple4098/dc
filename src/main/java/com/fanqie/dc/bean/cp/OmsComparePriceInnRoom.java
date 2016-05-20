package com.fanqie.dc.bean.cp;

import com.fanqie.core.Domain;
import com.fanqie.dc.enumeration.ComparePriceEnum;

import java.util.List;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2016/5/13
 * @version: v1.0.0
 */
public class OmsComparePriceInnRoom {
    private String  userCode;
    private String  recordCode;
    private Integer innId;
    private Integer otaId;
    private String innName;
    private String context;
    private String specialStartDate;
    private String specialEndDate;
    private ComparePriceEnum priceEnum;
    private List<OmsOtaRoomType> tomatoOmsOtaRoomtypeList;

    public OmsComparePriceInnRoom(String specialStartDate, String specialEndDate) {
        this.specialStartDate = specialStartDate;
        this.specialEndDate = specialEndDate;
    }

    public OmsComparePriceInnRoom() {
    }

    public ComparePriceEnum getPriceEnum() {
        return priceEnum;
    }

    public void setPriceEnum(ComparePriceEnum priceEnum) {
        this.priceEnum = priceEnum;
    }

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Integer getInnId() {
        return innId;
    }

    public void setInnId(Integer innId) {
        this.innId = innId;
    }

    public Integer getOtaId() {
        return otaId;
    }

    public void setOtaId(Integer otaId) {
        this.otaId = otaId;
    }

    public String getInnName() {
        return innName;
    }

    public void setInnName(String innName) {
        this.innName = innName;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getSpecialStartDate() {
        return specialStartDate;
    }

    public void setSpecialStartDate(String specialStartDate) {
        this.specialStartDate = specialStartDate;
    }

    public String getSpecialEndDate() {
        return specialEndDate;
    }

    public void setSpecialEndDate(String specialEndDate) {
        this.specialEndDate = specialEndDate;
    }

    public List<OmsOtaRoomType> getTomatoOmsOtaRoomtypeList() {
        return tomatoOmsOtaRoomtypeList;
    }

    public void setTomatoOmsOtaRoomtypeList(List<OmsOtaRoomType> tomatoOmsOtaRoomtypeList) {
        this.tomatoOmsOtaRoomtypeList = tomatoOmsOtaRoomtypeList;
    }
}
