package org.select.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.select.entity.CourseBean;
import org.select.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class CourseDaoTest {
    @Autowired
    private CourseDao courseDao;
    @Test
    public void findByName() {
        Course course=new Course();
        course.setCourseName("高等数学");
        //select courseId,courseName
        //List<Course> courses=courseDao.findByName(course);
        //courses.get(0).setCourseId(11);
        List<CourseBean> courses=courseDao.findByName2(course);
        courses.get(0).setCourseName("980");
        List<Course> coursesz=courseDao.findByName3(course);

        System.out.println(coursesz.get(0).getCourseName());
        //System.out.println(courses+"ddddd");
    }

    @Test
    public void findCount() {
        int  i=courseDao.findCount("5");
        System.out.println(i);
    }

    @Test
    public void update() {
        Course course=new Course();
       course.setCourseId(1);
       course=courseDao.findById(course.getCourseId());
       System.out.println(course);
       course.setCourseName("11111");
       courseDao.update(course);
       }
}