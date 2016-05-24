package com.fanqie.dc.bean.cp;

import com.fanqie.core.Domain;
import com.fanqie.dc.enumeration.ComparePriceEnum;

import java.util.Date;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2016/5/16
 * @version: v1.0.0
 */
public class ComparePriceData extends Domain{

    //客栈id
    private Integer innId;
    //客栈名称
    private String innName;
    //房型名称
    private String roomTypeName;
    //oms房型id
    private String omsRoomTypeId;
    //销售日期
    private Date sellingDate;
    //销售价格
    private Double sellingPrice;
    //渠道价格
    private Double otaSellingPrice;
    //渠道客栈id
    private String otaInnId;
    //渠道客栈名
    private String otaInnName;
    //渠道房型id
    private String otaRoomTypeId;
    //渠道id
    private String otaCode;

    private ComparePriceEnum priceEnum;

    public ComparePriceData() {
    }


    public ComparePriceData(Integer innId, String innName, String roomTypeName,
                            String omsRoomTypeId, Date sellingDate, Double sellingPrice, Double otaSellingPrice,
                            String oatInnName, String otaRoomTypeId, String otaCode) {
        this.innId = innId;
        this.innName = innName;
        this.roomTypeName = roomTypeName;
        this.omsRoomTypeId = omsRoomTypeId;
        this.sellingDate = sellingDate;
        this.sellingPrice = sellingPrice;
        this.otaSellingPrice = otaSellingPrice;
        this.otaInnName = oatInnName;
        this.otaRoomTypeId = otaRoomTypeId;
        this.otaCode = otaCode;
    }


    public ComparePriceEnum getPriceEnum() {
        return priceEnum;
    }

    public void setPriceEnum(ComparePriceEnum priceEnum) {
        this.priceEnum = priceEnum;
    }

    public String getOtaInnName() {
        return otaInnName;
    }

    public void setOtaInnName(String otaInnName) {
        this.otaInnName = otaInnName;
    }

    public Integer getInnId() {
        return innId;
    }

    public void setInnId(Integer innId) {
        this.innId = innId;
    }

    public String getInnName() {
        return innName;
    }

    public void setInnName(String innName) {
        this.innName = innName;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public String getOmsRoomTypeId() {
        return omsRoomTypeId;
    }

    public void setOmsRoomTypeId(String omsRoomTypeId) {
        this.omsRoomTypeId = omsRoomTypeId;
    }

    public Date getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(Date sellingDate) {
        this.sellingDate = sellingDate;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Double getOtaSellingPrice() {
        return otaSellingPrice;
    }

    public void setOtaSellingPrice(Double otaSellingPrice) {
        this.otaSellingPrice = otaSellingPrice;
    }

    public String getOtaInnId() {
        return otaInnId;
    }
    public void setOtaInnId(String otaInnId) {
        this.otaInnId = otaInnId;
    }

    public String getOtaRoomTypeId() {
        return otaRoomTypeId;
    }

    public void setOtaRoomTypeId(String otaRoomTypeId) {
        this.otaRoomTypeId = otaRoomTypeId;
    }

    public String getOtaCode() {
        return otaCode;
    }

    public void setOtaCode(String otaCode) {
        this.otaCode = otaCode;
    }
}
