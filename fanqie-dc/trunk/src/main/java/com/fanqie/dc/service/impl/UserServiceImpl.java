package com.fanqie.dc.service.impl;

import com.fanqie.dc.dao.IUserDao;
import com.fanqie.dc.domain.UserBean;
import com.fanqie.dc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DESC :
 * @author : 番茄木-ZLin
 * @data : 2015/5/11
 * @version: v1.0.0
 */
@Service
public class UserServiceImpl  implements IUserService {
  @Autowired
  private IUserDao userDao;
    @Override
    public void save(UserBean userBean) {
         userDao.saveUser(userBean);
    }

  @Override
  public List<UserBean> findAll() {
    return userDao.findAll();
  }
}
