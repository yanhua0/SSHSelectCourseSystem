package org.select.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.select.entity.Course;
import org.select.entity.Student;
import org.select.entity.User;
import org.select.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Scope("prototype")
public class StudentAction extends ActionSupport implements ModelDriven<Student> {
    private Student student=new Student();
    @Autowired
    private StudentService studentService;
    public Student getModel() {
        return student;
    }

    public String save()
    {  HttpServletRequest request= ServletActionContext.getRequest();
       User user= (User) ServletActionContext.getRequest().getSession().getAttribute("userexist");
       student.setUsername(user.getUsername());
       student.setStudentName(user.getName());
       studentService.save(student);
       return "saveSuccess";
    }
    public String findUsername()
    {
        List<Student> list= studentService.findByUsername(student);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("list",list);
        return "findCourse";
    }
    public String deleteCourse()
    {   student=studentService.findById(student.getId());
    if(student==null)
    {
        return "deleteFail";
    }
        studentService.deleteCourse(student);
        return "deleteSuccess";
    }

}
