package org.select.dao;

import org.select.entity.Student;

import java.util.List;

public interface StudentDao {
    void save(Student student);
    Student findByUsernameAndCourseId(Student student);
    List<Student> findByUsername(Student student);
    Student findById(Integer id);
    Student findByCourseId(Student student);
    void delete(Student student);
    void update(Student student);
}
