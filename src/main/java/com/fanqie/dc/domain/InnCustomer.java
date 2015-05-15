package com.fanqie.dc.domain;

import com.fanqie.core.Domain;

import java.math.BigDecimal;

/**
 * DESC : 客栈客户统计
 * @author : 番茄木-ZLin
 * @data : 2015/5/14
 * @version: v1.0.0
 */
public class InnCustomer extends Domain {
    //客户数量
    private int num;
    //省份
    private String  province;
    //所在城市
    private String city;
    //所在比例
    private BigDecimal percent;
    //客栈id
    private Integer innId;


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    public Integer getInnId() {
        return innId;
    }

    public void setInnId(Integer innId) {
        this.innId = innId;
    }
}
