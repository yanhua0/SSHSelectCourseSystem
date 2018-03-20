package org.select.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.select.dao.CourseDao;
import org.select.entity.Course;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

public class CourseDaoImpl extends HibernateDaoSupport implements CourseDao {
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
}
