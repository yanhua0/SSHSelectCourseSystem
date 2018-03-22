package org.select.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.select.entity.Student;
import org.select.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

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
    {  
       studentService.save(student);
       return "saveSuccess";
    }

}
