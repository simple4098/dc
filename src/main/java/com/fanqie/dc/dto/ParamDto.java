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

    //查询开始时间
    private String startDate;
    //查询结束时间
    private String endDate;
   //分类id
    private String tagId;
    //客栈id
    private Integer innId;
    //数据权限
    private boolean dataPermission;
    //公司id
    private String companyId;
    //用户id
    private String userId;
    //此用户所有管理的客栈集合
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
