package org.select.service;

import org.select.entity.Student;
import org.select.entity.User;

import java.util.List;

public interface StudentService {
    int save(Student student);
    Student findUsernameAndCourseId(Student student);
    List<Student> findByUsername(Student student);
    Student findById(Integer id);
    void deleteCourse(Student student);
   // List<Student> studentChoose(User user);
}
