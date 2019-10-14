package com.tutorial.contosouniversity.models;

import java.io.Serializable;
import java.time.LocalDate;
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

	private static final long serialVersionUID = -4167229996077175915L;
	
	private Integer id;
	private String lastName;
	private String firstMidName;
	private LocalDate enrollmentDate;
	
	private List<Enrollment> enrollments;
	
	// constructors
	public Student() { }
	
	public Student(String firstMidName, String lastName, LocalDate enrollmentDate) {
		this.firstMidName = firstMidName;
		this.lastName = lastName;
		this.enrollmentDate = enrollmentDate;
	}
	
	// Getters
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFirstMidName() {
		return firstMidName;
	}
	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}
	@OneToMany(mappedBy="student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Enrollment> getEnrollments() {
		return enrollments;
	}
	
	
	// Setters
	public void setId(Integer id) {
		this.id = id;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFirstMidName(String firstMidName) {
		this.firstMidName = firstMidName;
	}
	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

}
