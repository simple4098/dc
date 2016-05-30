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


    private List<CrmComparePriceData> roomTypeList;

    public List<CrmComparePriceData> getRoomTypeList() {
        return roomTypeList;
    }

    public void setRoomTypeList(List<CrmComparePriceData> roomTypeList) {
        this.roomTypeList = roomTypeList;
    }

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


}
