package org.select.dao.impl;

import org.select.dao.UserDao;
import org.select.entity.User;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    public User findByUsernameAndPassword(User user) {
        String hql = "from User where username=? and password=?";

        List<User> list = (List<User>) this.getHibernateTemplate().find(hql,user.getUsername(),user.getPassword());
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
