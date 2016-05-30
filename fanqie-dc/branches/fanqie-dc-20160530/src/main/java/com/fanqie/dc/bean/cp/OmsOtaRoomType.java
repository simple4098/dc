package com.fanqie.dc.bean.cp;

/**
 * DESC : oms roomTypeId ， otaRoomTypeId
 * @author : 番茄木-ZLin
 * @data : 2016/5/13
 * @version: v1.0.0
 */
public class OmsOtaRoomType {
    //otaRoomTypeId
    private Integer id;
    //omsRoomTypeId
    private Integer roomTypeId;
    private String roomTypeName;

    public OmsOtaRoomType() {
    }

    public OmsOtaRoomType(Integer id, String roomTypeName) {
        this.id = id;
        this.roomTypeName = roomTypeName;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }
}
