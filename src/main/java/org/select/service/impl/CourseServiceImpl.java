package org.select.service.impl;

import org.select.dao.CourseDao;
import org.select.dao.StudentDao;
import org.select.entity.Course;
import org.select.entity.PageBean;
import org.select.entity.Student;
import org.select.entity.User;
import org.select.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private StudentDao studentDao;



    public PageBean<Course> findByPage(Integer currPage) {
        PageBean<Course> pageBean=new PageBean<Course>();
        pageBean.setCurrPage(currPage);
        int pageSize=10;
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

    public List<Course> findByName(Course course) {
        return courseDao.findByName(course);
    }

    public List<Course> findAll() {
        return courseDao.findAllC();
    }
    public List<Student> studentChoose(User user) {
        List<Course> courseList=courseDao.findAllC();
        int count=courseDao.findCount();
        List<Student> studentChoose=new ArrayList<Student>();
        List<Course> courseAll=courseDao.findAllC();
        int[] courseId=new int[count];
        Student[] studentlist=new Student[count];
        try{
            for(int i=0;i<count;i++)
            {   studentlist[i]=new Student();
                courseId[i]=courseAll.get(i).getCourseId();
                studentlist[i].setUsername(user.getUsername());
                studentlist[i].setCourseId(courseId[i]);
                studentlist[i]=studentDao.findByUsernameAndCourseId(studentlist[i]);
                if(studentlist[i]!=null)
                    studentChoose.add(studentlist[i]);
            }
            return  studentChoose;
        }catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }



}
