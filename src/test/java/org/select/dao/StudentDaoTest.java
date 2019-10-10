package org.select.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.select.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
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

    @Test
    public void findByUsername() {
        Student student=new Student();
        student.setUsername("1");
        List<Student> list=studentDao.findByUsername(student);
        System.out.println(list);
    }

    @Test
    public void delete() {
        Student student=new Student();
        student.setId(29);
        Student student1=studentDao.findById(student.getId());
        studentDao.delete(student1);
    }

    @Test
    public void findByCourseId() {
        Student student=new Student();
        student.setCourseId(2);
        student=studentDao.findByCourseId(student);
        System.out.println(student);
    }

    @Test
    public void findById() {
        Student student=studentDao.findById(30);
      student.setUsername("123");
        System.out.println(student);
    }
}