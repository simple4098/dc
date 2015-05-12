package com.fanqie.dc.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * DESC : Domain 基类
 * @author : 番茄木-ZLin
 * @data : 2015/5/12
 * @version: v1.0.0
 */
public class BaseDomain implements Serializable {
    private String id;
    //创建时间
    private Date  createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
