package org.select.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.select.entity.Course;
import org.select.entity.PageBean;
import org.select.service.CourseService;

public class CourseAction extends ActionSupport implements ModelDriven<Course> {
    private Course course=new Course();
    private CourseService courseService;

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    public Course getModel() {
        return course;
    }
    int currPage=1;

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public String findAll()
    {
        PageBean<Course> pageBean=courseService.findByPage(currPage);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }
}
