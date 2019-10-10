package org.select.dao.impl;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.select.dao.CourseDao;
import org.select.entity.CourseBean;
import org.select.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * hibernate查询时，必须映射接收实体的所有属性，可以通过findName3的方法进行规避
 * hibernate在修改时候，如果字段没有进行修改，那么不会执行sql
 */
@Repository
public class CourseDaoImpl extends HibernateDaoSupport implements CourseDao {
    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    public int findCount(String courseName) {
        if(courseName!=null)
        {
            List<Long> list=(List<Long>) this.getHibernateTemplate().find
                    ("select count(*)from Course where  courseName like ?",
                            "%"+courseName+"%");
           if (list.size()>0)
           {
               return list.get(0).intValue();
           }
        }else{
            String hql="select count(*) from Course";
            List<Long> list= (List<Long>) this.getHibernateTemplate().find(hql);
            if(list.size()>0)
            {
                return list.get(0).intValue();
            }

        }
        return 0;
     }

    public List<Course> findByPage(String courseName,int begin, int pageSize) {
        DetachedCriteria criteria=DetachedCriteria.forClass(Course.class);
        if(courseName!=null)
        {
            criteria.add(Restrictions.like("courseName","%"+courseName+"%"));
        }
       List<Course> list= (List<Course>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
       return list;
    }

    public List<Course> findByNameC(String courseName) {
        DetachedCriteria criteria=DetachedCriteria.forClass(Course.class);
        if(courseName!=null)
        {
            criteria.add(Restrictions.eq("courseName",courseName));
          //  criteria.add(Restrictions.ge());
        }
        List<Course> list= (List<Course>) this.getHibernateTemplate().findByCriteria(criteria);
        return list;
    }

    public List<Course> findByName(Course course)
       {/*String hql="from Course where course_name=?";
        return (List<Course>) this.getHibernateTemplate().find(hql,course.getCourseName());*/
           List<Course> courses=(List<Course>) this.getHibernateTemplate().find
                   ("from Course where  courseName like ?",
                           "%"+course.getCourseName()+"%");
           //this.getHibernateTemplate().getSessionFactory().getCurrentSession().clear();
          return courses;
       }

    /**
     * 推荐使用*****，站位可以写？或者(:name)，连表查询时专用
     * @param course
     * @return
     */
    public List<CourseBean> findByName2(Course course)
    {/*String hql="from Course where course_name=?";
        return (List<Course>) this.getHibernateTemplate().find(hql,course.getCourseName());*/
        String sql="select " +
                " c.course_id course_id," +
                "  " +
                " c.course_name," +
                " c.number," +
                " c.teacher_id," +
                " c.teacher_name \n" +
                "    from\n" +
                "        course c\n" +
                "    where\n" +
                "        c.course_name = :name";
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        SQLQuery query = session.createSQLQuery(sql);//写数据库sql
        List<String> list=new ArrayList<String>();
        query.setParameter("name",course.getCourseName());
        //query.setParameter(0,course.getCourseName());使用?
        //清除session.clear();否则set方法hibernate会调用更新方法
        return query.addEntity(CourseBean.class).list();
    }

    /**
     * 可以少写实体***，单表查询使用
     * @param course
     * @return
     */
    public List<Course> findByName3(Course course)
    {/*String hql="from Course where course_name=?";
        return (List<Course>) this.getHibernateTemplate().find(hql,course.getCourseName());*/
        String hql=" select new Course(courseId,courseName) from Course ";
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        Query query = session.createQuery(hql);//使用对象的字段作为查询
        return query.list();
    }
    public List<String> findByString(Course course)
    {/*String hql="from Course where course_name=?";
        return (List<Course>) this.getHibernateTemplate().find(hql,course.getCourseName());*/
        String hql=" select courseName from Course ";
        return (List<String>) getHibernateTemplate().find(hql);
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
