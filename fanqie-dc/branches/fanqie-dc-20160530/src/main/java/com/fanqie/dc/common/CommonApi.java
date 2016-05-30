package com.fanqie.dc.common;

/**
 * DESC : 请求数据中心接口
 * @author : 番茄木-ZLin
 * @data : 2015/5/27
 * @version: v1.0.0
 */
public class CommonApi {

    public static  String checkRoom;
    public static  String roomStatus;
    public static  String crmBangUrl;
    public static  String spiderUrl;
    public static  String updateOmsPriceRecord;


    public  String getUpdateOmsPriceRecord() {
        return updateOmsPriceRecord;
    }

    public  void setUpdateOmsPriceRecord(String updateOmsPriceRecord) {
        CommonApi.updateOmsPriceRecord = updateOmsPriceRecord;
    }

    public  String getRoomStatus() {
        return roomStatus;
    }

    public  void setRoomStatus(String roomStatus) {
        CommonApi.roomStatus = roomStatus;
    }

    public  String getCheckRoom() {
        return checkRoom;
    }

    public  void setCheckRoom(String checkRoom) {
        CommonApi.checkRoom = checkRoom;
    }

    public  String getCrmBangUrl() {
        return crmBangUrl;
    }

    public  void setCrmBangUrl(String crmBangUrl) {
        CommonApi.crmBangUrl = crmBangUrl;
    }

    public  String getSpiderUrl() {
        return spiderUrl;
    }

    public  void setSpiderUrl(String spiderUrl) {
        CommonApi.spiderUrl = spiderUrl;
    }
}
