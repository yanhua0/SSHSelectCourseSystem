package org.select.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.select.dao.CourseDao;
import org.select.entity.Course;
import org.select.entity.PageBean;
import org.select.entity.Student;
import org.select.entity.User;
import org.select.service.CourseService;
import org.select.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@Scope("prototype")
public class CourseAction extends ActionSupport implements ModelDriven<Course> {
    private Course course=new Course();
    @Autowired
    private CourseService courseService;
    public Course getModel() {
        return course;
    }
    int currPage=1;

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public String findAll()
    {   HttpServletRequest request = ServletActionContext.getRequest();
        User user= (User) ServletActionContext.getRequest().getSession().getAttribute("userexist");
        System.out.println(user);

        List<Student> list=courseService.studentChoose(user);
        System.out.println(list);
        request.setAttribute("studentlist",list);
        PageBean<Course> pageBean=courseService.findByPage(currPage);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }
    public String findName()
     {  HttpServletRequest request= ServletActionContext.getRequest();
        List<Course> course1=courseService.findByName(course);
        User user= (User) ServletActionContext.getRequest().getSession().getAttribute("userexist");
        List<Student> list=courseService.studentChoose(user);
        System.out.println(list);
        request.setAttribute("studentlist",list);
        request.setAttribute("list", course1);

        return "findName";
    }
    public String updateUI()
    {   course=courseService.findById(course.getCourseId());

        return "updateUI";
    }
    public String update()
    {  try {
         courseService.update(course);
        return "updateSuccess";
     }catch (Exception e)
     {
        e.getMessage();
         return INPUT;
     }

    }

}
