package org.select.interceptor;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.select.entity.User;

import java.util.Map;

public class LoginInterceptor extends AbstractInterceptor {
    public String intercept(ActionInvocation invocation) throws Exception {
        Map session = invocation.getInvocationContext().getSession();
        User user= (User) session.get("userexist");

        if (user!=null) {
            System.out.println("拦截器：合法用户登录---");
            return invocation.invoke();
        } else {
            System.out.println("拦截器：用户未登录---");
            return Action.LOGIN;
        }
    }
}
