package com.tutorial.contosouniversity.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

enum Grade {
    A, B, C, D, F
}

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Enrollment")
public class Enrollment implements Serializable {

    private static final long serialVersionUID = -4100263328202519026L;

    protected Integer enrollmentId;
    protected Grade grade;
    
    protected Student student;
    protected Course course;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Integer enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    @Enumerated(EnumType.STRING)
    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @ManyToOne
    @JoinColumn(name = "student_id")
    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne
    @JoinColumn(name = "course_id")
    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}