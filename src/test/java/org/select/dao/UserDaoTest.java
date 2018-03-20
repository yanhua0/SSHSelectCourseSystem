package org.select.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.select.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserDaoTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void findByUsernameAndPassword() {
        User user=new User();
        user.setUsername("1");
        user.setPassword("1");
        User user2=userDao.findByUsernameAndPassword(user);
        System.out.println(user2+"jjjjjjjjjjj");
    }
}