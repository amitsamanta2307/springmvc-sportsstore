package com.tutorial.contosouniversity.models;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "Student")
public class Student implements Serializable {

    private static final long serialVersionUID = -5077437835960815752L;

    protected Integer id;
    protected String lastName;
    protected String firstMidName;
    protected Date enrollmentDate;

    protected List<Enrollment> enrollments;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstMidName() {
        return firstMidName;
    }

    public void setFirstMidName(String firstMidName) {
        this.firstMidName = firstMidName;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @OneToMany(mappedBy="student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Enrollment> getEnrollment() {
        return enrollments;
    }

    public void setEnrollment(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}