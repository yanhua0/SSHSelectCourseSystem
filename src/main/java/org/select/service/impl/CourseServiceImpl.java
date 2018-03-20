package org.select.service.impl;

import org.select.dao.CourseDao;
import org.select.entity.Course;
import org.select.entity.PageBean;
import org.select.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao;

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public PageBean<Course> findByPage(Integer currPage) {
        PageBean<Course> pageBean=new PageBean<Course>();
        pageBean.setCurrPage(currPage);
        int pageSize=5;
        pageBean.setPageSize(pageSize);
        int count=courseDao.findCount();
        pageBean.setTotalCount(count);
        double tc = count;
        Double num = Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());//总共页数计算

        int begin = (currPage - 1)*pageSize;//开始页计算
        List<Course> list = courseDao.findByPage(begin, pageSize);
        pageBean.setList(list);
        return pageBean;
    }
}
