package com.tutorial.contosouniversity.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Course")
public class Course implements Serializable {

    private static final long serialVersionUID = 610099220126433920L;

    protected Integer courseId;
    protected String title;
    protected Integer credits;

    protected List<Enrollment> enrollments;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    @OneToMany(mappedBy="course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Enrollment> getEnrollment() {
        return enrollments;
    }

    public void setEnrollment(List<Enrollment> enrollemnts) {
        this.enrollments = enrollemnts;
    }
}