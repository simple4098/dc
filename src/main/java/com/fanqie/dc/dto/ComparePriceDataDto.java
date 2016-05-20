package com.fanqie.dc.dto;

import com.fanqie.dc.bean.cp.ComparePriceData;

import java.util.Date;
import java.util.List;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2016/5/17
 * @version: v1.0.0
 */
public class ComparePriceDataDto {

    private Integer innId;

    private Date startDate;

    private Date endDate;

    private List<ComparePriceData> list;

    private String innCode;

    public Integer getInnId() {
        return innId;
    }

    public void setInnId(Integer innId) {
        this.innId = innId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<ComparePriceData> getList() {
        return list;
    }

    public void setList(List<ComparePriceData> list) {
        this.list = list;
    }

    public void setInnCode(String innCode) {
        this.innCode = innCode;
    }

    public String getInnCode() {
        return innCode;
    }
}
