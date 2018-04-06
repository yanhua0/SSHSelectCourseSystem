package org.select.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.select.entity.User;
import org.select.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        HttpSession session= request.getSession();
        User userexist = userService.login(user);
        if (userexist == null) {
            this.addActionError("用户名或密码错误！");
            return INPUT;
        }
        else {
            ActionContext.getContext().getSession().put("userexist",userexist);
            Cookie cookieSId = new Cookie("JSESSIONID",session.getId());
            cookieSId.setMaxAge(60*60);
            cookieSId.setPath("/");
            response.addCookie(cookieSId);
             return SUCCESS;
     }

    }
    public String save()
    {
        return "saveSuccess";
    }
    public String exit()
    {
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpSession session= request.getSession();
        session.invalidate();
        return INPUT;
    }
}
