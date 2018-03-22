package org.select.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.select.entity.Student;
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
public class StudentDaoTest {
    @Autowired
    private StudentDao studentDao;
    @Test
    public void save() {
        Student student=new Student();
        student.setClassroom("1");
        student.setCourseId(1222);
        student.setCourseName("1");
        student.setTeacherName("222555");
        student.setStudentName("1");
        student.setUsername("sss");
        studentDao.save(student);
    }

    @Test
    public void findByUsernameAndCourseId() {
        Student student=new Student();
        student.setCourseId(1222);
        student.setUsername("sss");
       student= studentDao.findByUsernameAndCourseId(student);

    }
}