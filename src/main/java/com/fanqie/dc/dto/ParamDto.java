package com.fanqie.dc.dto;

import java.util.List;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/17
 * @version: v1.0.0
 */
public class ParamDto {

    private String startDate;

    private String endDate;

    private String tagId;

    private Integer innId;
    //数据权限
    private boolean dataPermission;
    //公司id
    private String companyId;
    private String userId;
    private List<Integer> innIds;

    public List<Integer> getInnIds() {
        return innIds;
    }

    public void setInnIds(List<Integer> innIds) {
        this.innIds = innIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isDataPermission() {
        return dataPermission;
    }

    public void setDataPermission(boolean dataPermission) {
        this.dataPermission = dataPermission;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public Integer getInnId() {
        return innId;
    }

    public void setInnId(Integer innId) {
        this.innId = innId;
    }
}
