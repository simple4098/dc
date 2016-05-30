package com.fanqie.dc.dto;

import com.fanqie.dc.bean.cp.ComparePriceData;

import java.util.List;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2016/5/16
 * @version: v1.0.0
 */
public class CrmComparePriceDto {
    private String innName;
    private String contact;
    private String createdTime;
    private List<CrmComparePriceDataDto> priceDtoList;

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getInnName() {
        return innName;
    }

    public void setInnName(String innName) {
        this.innName = innName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<CrmComparePriceDataDto> getPriceDtoList() {
        return priceDtoList;
    }

    public void setPriceDtoList(List<CrmComparePriceDataDto> priceDtoList) {
        this.priceDtoList = priceDtoList;
    }
}
