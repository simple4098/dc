package com.fanqie.dc.dto;

import java.util.List;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2016/5/16
 * @version: v1.0.0
 */
public class CrmComparePriceData {
    //房型名称
    private String roomTypeName;

    private List<CrmComparePriceDataDto> roomDetail;

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public List<CrmComparePriceDataDto> getRoomDetail() {
        return roomDetail;
    }

    public void setRoomDetail(List<CrmComparePriceDataDto> roomDetail) {
        this.roomDetail = roomDetail;
    }
}
