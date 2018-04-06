package org.select.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.select.dao.CourseDao;
import org.select.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
@Repository
public class CourseDaoImpl extends HibernateDaoSupport implements CourseDao {
    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    public int findCount() {
        String hql="select count(*) from Course";
        List<Long> list= (List<Long>) this.getHibernateTemplate().find(hql);
        if(list.size()>0)
        {
            return list.get(0).intValue();
        }
        return 0;
     }

    public List<Course> findByPage(int begin, int pageSize) {
        DetachedCriteria criteria=DetachedCriteria.forClass(Course.class);
        List<Course> list= (List<Course>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
       return list;
    }



    public List<Course> findByName(Course course)
       {/*String hql="from Course where course_name=?";
        return (List<Course>) this.getHibernateTemplate().find(hql,course.getCourseName());*/
          return (List<Course>) this.getHibernateTemplate().find
                  ("from Course where  course_name like ?",
                          "%"+course.getCourseName()+"%");
       }

    public List<Course> findAllC() {
       return (List<Course>) this.getHibernateTemplate().find("from Course");
    }

    public Course findById(Integer id) {
        return this.getHibernateTemplate().get(Course.class,id);
    }

    public void update(Course course) {
        this.getHibernateTemplate().update(course);
    }
}
