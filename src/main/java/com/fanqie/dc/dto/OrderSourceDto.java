package com.fanqie.dc.dto;

import com.fanqie.dc.domain.OrderSource;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2015/5/26
 * @version: v1.0.0
 */
public class OrderSourceDto extends OrderSource{

    //空置房间数
    private Integer emptyRoomNum;
    //总间夜数
    private Integer totalRoomNum;

    public Integer getEmptyRoomNum() {
        return emptyRoomNum;
    }

    public void setEmptyRoomNum(Integer emptyRoomNum) {
        this.emptyRoomNum = emptyRoomNum;
    }

    public Integer getTotalRoomNum() {
        return totalRoomNum;
    }

    public void setTotalRoomNum(Integer totalRoomNum) {
        this.totalRoomNum = totalRoomNum;
    }
}
