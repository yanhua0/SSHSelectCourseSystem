package org.select.service.impl;

import org.select.dao.UserDao;
import org.select.entity.User;
import org.select.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User login(User user) {
    return userDao.findByUsernameAndPassword(user);
    }
}
