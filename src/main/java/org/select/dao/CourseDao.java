package org.select.dao;

import org.select.entity.Course;

import java.util.List;

public interface CourseDao {
    int findCount();
    List<Course> findByPage(int begin,int pageSize);
    List<Course> findByName(Course course);
    List<Course> findAllC();
}
