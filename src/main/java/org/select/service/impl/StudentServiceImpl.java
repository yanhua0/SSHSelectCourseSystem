package org.select.service.impl;

import org.select.dao.CourseDao;
import org.select.dao.StudentDao;
import org.select.entity.Student;
import org.select.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Autowired
    private CourseDao courseDao;

    public int save(Student student) {
        try{
          Student  student1=studentDao.findByUsernameAndCourseId(student);
            System.out.println(student1+"sssss");
            if(student1==null)
            {
                studentDao.save(student);
                return 0;
            }
        }catch (Exception e)
        {
            e.getMessage();
        }
        return 1;
   }

    public Student findUsernameAndCourseId(Student student) {
         return  studentDao.findByUsernameAndCourseId(student);
    }

    public List<Student> findByUsername(Student student) {
        return studentDao.findByUsername(student);
    }

    public Student findById(Integer id) {
       return studentDao.findById(id);
    }

    public void deleteCourse(Student student) {
        studentDao.delete(student);
    }
//    public List<Student> studentChoose(User user) {
//        List<Course> courseList=courseDao.findAllC();
//         System.out.println("1");
//        int count=courseDao.findCount();
//        System.out.println("2");
//        List<Student> studentChoose=new ArrayList<Student>();
//        List<Course> courseAll=courseDao.findAllC();
//        System.out.println("3");
//        int[] courseId=new int[count];
//        Student[] studentlist=new Student[count];
//        System.out.println("4");
//      try{
//          for(int i=0;i<count;i++)
//          {   studentlist[i]=new Student();
//              courseId[i]=courseAll.get(i).getCourseId();
//              System.out.println("5");
//              studentlist[i].setUsername(user.getUsername());
//              System.out.println("6");
//               studentlist[i].setCourseId(courseId[i]);
//               studentlist[i]=studentDao.findByUsernameAndCourseId(studentlist[i]);
//               if(studentlist[i]!=null)
//              studentChoose.add(studentlist[i]);
//          }
//          return  studentChoose;
//      }catch (Exception e)
//      {
//          e.getMessage();
//      }
//        return null;
//    }
}
