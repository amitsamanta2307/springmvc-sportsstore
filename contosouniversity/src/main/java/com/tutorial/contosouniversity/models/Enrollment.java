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

	private static final long serialVersionUID = 449707116262405715L;
	
	private Integer enrollmentId;
    private Grade grade;
    
    private Student student;
    private Course course;
    
    public Enrollment() { }
    
    public Enrollment(Grade grade) {
    	this.grade = grade;
    }
    
    
    // Getters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getEnrollmentId() {
		return enrollmentId;
	}
    
    @Enumerated(EnumType.STRING)
	public Grade getGrade() {
		return grade;
	}
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    public Student getStudent() {
		return student;
	}
    
    @ManyToOne
    @JoinColumn(name = "course_id")
	public Course getCourse() {
		return course;
	}
	
    // Setters
	public void setEnrollmentId(Integer enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public void setCourse(Course course) {
		this.course = course;
	}

}
