package org.select.service.impl;

import org.select.dao.UserDao;
import org.select.entity.User;
import org.select.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public User login(User user) {
    return userDao.findByUsernameAndPassword(user);
    }
}
