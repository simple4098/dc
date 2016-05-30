package com.fanqie.dc.dto;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2016/5/16
 * @version: v1.0.0
 */
public class CrmBangDto {

    //第三方客栈id
    private String channelInnId;
    //第三方房型id
    private String channelRoomTypeId;
    //类型
    private String channelType;
    //客栈id
    private Integer innId;
    //oms otaRoomTypeId
    private Integer otaRoomTypeId;
    //oms roomTypeId
    private Integer roomTypeId;
    private String roomTypeName;

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public String getChannelInnId() {
        return channelInnId;
    }

    public void setChannelInnId(String channelInnId) {
        this.channelInnId = channelInnId;
    }

    public String getChannelRoomTypeId() {
        return channelRoomTypeId;
    }

    public void setChannelRoomTypeId(String channelRoomTypeId) {
        this.channelRoomTypeId = channelRoomTypeId;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public Integer getInnId() {
        return innId;
    }

    public void setInnId(Integer innId) {
        this.innId = innId;
    }

    public Integer getOtaRoomTypeId() {
        return otaRoomTypeId;
    }

    public void setOtaRoomTypeId(Integer otaRoomTypeId) {
        this.otaRoomTypeId = otaRoomTypeId;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }
}
