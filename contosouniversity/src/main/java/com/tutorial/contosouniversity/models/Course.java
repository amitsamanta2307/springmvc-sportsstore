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

	private static final long serialVersionUID = -6971930528296374044L;

	private Integer courseId;
	private String title;
	private Integer credits;
	
	private List<Enrollment> enrollments;
	
	public Course() { }
	
	public Course(Integer courseId, String title, Integer credits) {
		this.courseId = courseId;
		this.title = title;
		this.credits = credits;
	}
	
	// Getters
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getCourseId() {
		return courseId;
	}
	public String getTitle() {
		return title;
	}
	public Integer getCredits() {
		return credits;
	}
	@OneToMany(mappedBy="course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Enrollment> getEnrollments() {
		return enrollments;
	}
	
	// Setters
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
}
