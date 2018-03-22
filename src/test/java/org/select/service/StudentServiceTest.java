package org.select.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.select.dao.CourseDao;
import org.select.entity.Course;
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
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;
    @Autowired
    private  UserService userService;
    @Autowired
    private CourseDao courseDao;
    @Test
    public void save() {
        Student student=new Student();
        student.setCourseId(1);
        student.setUsername("1");
       studentService.save(student);
    }

    @Test
    public void studentChoose() {


    }
}