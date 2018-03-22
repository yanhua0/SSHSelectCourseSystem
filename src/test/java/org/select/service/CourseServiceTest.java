package org.select.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.select.entity.Student;
import org.select.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class CourseServiceTest {
    @Autowired
    private CourseService courseService;
    @Test
    public void findByPage() {
    }

    @Test
    public void studentChoose() {
        User user=new User();
        user.setUsername("1");
        List<Student> list= courseService.studentChoose(user);
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.size());
    }
}