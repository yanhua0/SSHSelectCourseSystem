package org.select.dao.impl;

import org.hibernate.SessionFactory;
import org.select.dao.StudentDao;
import org.select.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {
    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    public void save(Student student) {
      this.getHibernateTemplate().save(student);
    }

    public Student findByUsernameAndCourseId(Student student) {
       String hql="from Student where username=? and course_id=?";
        List<Student> list= (List<Student>) this.getHibernateTemplate().find(hql,student.getUsername(),student.getCourseId());
         if(list.size()>0)
         {
             return list.get(0);
         }
         return null;
    }

    public List<Student> findByUsername(Student student) {
        String hql="from Student where username=?";
        List<Student> list= (List<Student>) this.getHibernateTemplate().find(hql,student.getUsername());
        if(list.size()==0)
        {
            hql="from Student where teacher_id=?";
            list= (List<Student>) this.getHibernateTemplate().find(hql,student.getUsername());
        }

        return list;
    }

    public Student findById(Integer id) {
       return this.getHibernateTemplate().get(Student.class,id);
    }

    public Student findByCourseId(Student student) {
        String hql="from Student where course_id=?";
        List<Student> list= (List<Student>) this.getHibernateTemplate().find(hql,student.getCourseId());
        if(list.size()>0)
        {
            return list.get(0);
        }
        return null;
    }
    public void delete(Student student) {
        this.getHibernateTemplate().delete(student);
    }

    public void update(Student student) {
        this.getHibernateTemplate().update(student);
    }
}
