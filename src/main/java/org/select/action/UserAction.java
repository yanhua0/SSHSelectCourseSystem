package org.select.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.select.entity.User;
import org.select.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user=new User();
    @Autowired
    private UserService userService;
    public User getModel() {
        return user;
    }

    public String login() {
        User userexist = userService.login(user);
        if (userexist == null) {
            this.addActionError("用户名或密码错误！");
            return INPUT;
        }
        else {
            ActionContext.getContext().getSession().put("userexist",userexist);
            return SUCCESS;
        }
    }
    public String save()
    {  System.out.println("dddddddddddddddddddddddddddddddddddddddd");
        // studentService.save(student);
        return "saveSuccess";
    }
}
