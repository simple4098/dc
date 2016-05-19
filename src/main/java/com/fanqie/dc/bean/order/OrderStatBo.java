package com.fanqie.dc.bean.order;

/**
 * desc:
 * author:lzb
 * date:2015/9/22
 */
public class OrderStatBo {
    private String from;
    private String to;
    private Integer otaId;


    public Integer getOtaId() {
        return otaId;
    }

    public void setOtaId(Integer otaId) {
        this.otaId = otaId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
