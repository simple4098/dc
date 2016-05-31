package com.fanqie.dc.dto;

import com.fanqie.core.Domain;

import java.util.Date;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2016/5/16
 * @version: v1.0.0
 */
public class CrmComparePriceDataDto {

    //销售日期
    private String sellingDate;
    //销售价格
    private Double sellingPrice;
    //渠道价格
    private Double otaSellingPrice;


    public CrmComparePriceDataDto() {
    }



    public String getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(String sellingDate) {
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
}
