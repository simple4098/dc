package com.fanqie.dc.dao.impl;

import com.fanqie.dc.dao.base.BaseDcDaoImpl;
import com.fanqie.dc.dao.IUserDao;
import com.fanqie.dc.domain.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DESC :
 *
 * @author : 番茄木-ZLin
 * @data : 2015/5/11
 * @version: v1.0.0
 */
@Repository
public class UserDao extends BaseDcDaoImpl<UserBean> implements IUserDao {
    private static  final String NA = "com.fanqie.dc.domain.UserBean.";

    @Override
    public void saveUser(UserBean userBean) {
        templateDc.insert(NA.concat("save"),userBean);
    }

    @Override
    public List<UserBean> findAll() {
        return templateDc.selectList(NA.concat("findAll"));
    }
}
