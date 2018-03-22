package org.select.dao.impl;


import org.hibernate.SessionFactory;
import org.select.dao.UserDao;
import org.select.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    public User findByUsernameAndPassword(User user) {
        String hql = "from User where username=? and password=?";

        List<User> list = (List<User>) this.getHibernateTemplate().find(hql,user.getUsername(),user.getPassword());
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public void save(User user) {
        this.getHibernateTemplate().save(user);
    }
}
