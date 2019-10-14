package com.tutorial.contosouniversity.services;

import java.util.List;

import com.tutorial.contosouniversity.models.Course;

public interface CourseService {
	
	public Course create(Course shop);
    public Course delete(int id);
    public List<Course> findAll();
    public Course update(Course shop);
    public Course findById(int id);

}
