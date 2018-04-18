package org.select.dao;

import org.select.entity.Course;

import java.util.List;

public interface CourseDao {
    int findCount(String courseName);
    List<Course> findByPage(String courseName,int begin,int pageSize);
    List<Course> findByName(Course course);
    List<Course> findAllC();
    Course findById(Integer id);
    void update(Course course);
}
