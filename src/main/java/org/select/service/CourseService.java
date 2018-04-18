package org.select.service;

import org.select.entity.Course;
import org.select.entity.PageBean;
import org.select.entity.Student;
import org.select.entity.User;

import java.util.List;

public interface CourseService {
    PageBean<Course> findByPage(String courseName,Integer currPage);
    List<Course> findByName(Course course);
    List<Course> findAll();
    List<Student> studentChoose(User user);
    void update(Course course);
    Course findById(Integer id);
}
