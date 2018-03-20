package org.select.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.select.entity.User;
import org.select.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user=new User();
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

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
}
