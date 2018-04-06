package org.select.entity;

import javax.persistence.*;

@Entity
@Table(name="course",schema = "selectcourse")
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "course_id")
    private int courseId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "teacher_name")
    private String teacherName;
    @Column(name = "classroom")
    private String classroom;
    @Column(name = "number")
    private int number;
    @Column(name = "teacher_id")
    private String teacherId;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", classroom='" + classroom + '\'' +
                ", number=" + number +
                ", teacherId=" + teacherId +
                '}';
    }
}
