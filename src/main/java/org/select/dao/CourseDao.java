package org.select.dao;

import org.select.entity.CourseBean;
import org.select.entity.Course;

import java.util.List;

public interface CourseDao {
    int findCount(String courseName);
    List<Course> findByPage(String courseName,int begin,int pageSize);
    List<Course> findByName(Course course);
    List<CourseBean> findByName2(Course course);
    List<Course> findAllC();
    Course findById(Integer id);
    void update(Course course);
    List<String> findByString(Course course);
    List<Course> findByName3(Course course);
}
