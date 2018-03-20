package org.select.service;

import org.select.entity.Course;
import org.select.entity.PageBean;

public interface CourseService {
    PageBean<Course> findByPage(Integer currPage);
}
