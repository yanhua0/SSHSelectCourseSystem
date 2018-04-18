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

import java.util.Arrays;
import java.util.Map;


@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user=new User();
    @Autowired
    private UserService userService;
    public User getModel() {
        return user;
    }

    public String login(){
        //获取前端数据
        ActionContext context=ActionContext.getContext();
        Map<String,Object> map=context.getParameters();

        for (String key : map.keySet()) {
            Object[] obj= (Object[]) map.get(key);
            System.out.println("key= "+key+" and value= "+map.get(key)+"and object="+ Arrays.toString(obj));

        }
        //第二种实验ServletActionContext

        HttpServletRequest request= ServletActionContext.getRequest();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println("username="+username+"password="+password);
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
