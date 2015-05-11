package com.fanqie.dc.domain;

import java.io.Serializable;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/11
 * @version: v1.0.0
 */
public class UserBean implements Serializable {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
