package com.fanqie.dc.service;

import com.fanqie.dc.dao.base.IBaseDcDao;
import com.fanqie.dc.domain.UserBean;

import java.util.List;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2015/5/11
 * @version: v1.0.0
 */
public interface  IUserService  {
    void save(UserBean userBean);

    List<UserBean> findAll();

}
