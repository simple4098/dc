package com.fanqie.dc.bean.cp;

import com.fanqie.core.Domain;

/**
 * DESC : 比较系统配置
 * @author : 番茄木-ZLin
 * @data : 2016/5/13
 * @version: v1.0.0
 */
public class ComparePriceConf  extends Domain {

    private Integer otaId;
    private String otaCode;
    private Integer percentage;
    private String  account;
    private String  password;
    private boolean compareDefault;
    private int spiderDay;

    public int getSpiderDay() {
        return spiderDay;
    }

    public void setSpiderDay(int spiderDay) {
        this.spiderDay = spiderDay;
    }

    public Integer getOtaId() {
        return otaId;
    }

    public void setOtaId(Integer otaId) {
        this.otaId = otaId;
    }

    public String getOtaCode() {
        return otaCode;
    }

    public void setOtaCode(String otaCode) {
        this.otaCode = otaCode;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCompareDefault() {
        return compareDefault;
    }

    public void setCompareDefault(boolean compareDefault) {
        this.compareDefault = compareDefault;
    }
}
