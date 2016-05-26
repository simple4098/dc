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

    private String startDate;

    private String endDate;

    private List<ComparePriceData> comparePriceDataList;

    private String otaCode;


    public ComparePriceDataDto(Integer innId, String otaCode, String startDate, String endDate) {
        this.innId = innId;
        this.otaCode = otaCode;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ComparePriceDataDto() {
    }

    public Integer getInnId() {
        return innId;
    }

    public void setInnId(Integer innId) {
        this.innId = innId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<ComparePriceData> getComparePriceDataList() {
        return comparePriceDataList;
    }

    public void setComparePriceDataList(List<ComparePriceData> comparePriceDataList) {
        this.comparePriceDataList = comparePriceDataList;
    }

    public String getOtaCode() {
        return otaCode;
    }

    public void setOtaCode(String otaCode) {
        this.otaCode = otaCode;
    }
}
