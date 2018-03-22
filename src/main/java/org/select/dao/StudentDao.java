package org.select.dao;

import org.select.entity.Student;

public interface StudentDao {
    void save(Student student);
    Student findByUsernameAndCourseId(Student student);
}
