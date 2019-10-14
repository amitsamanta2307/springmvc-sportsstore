package com.tutorial.contosouniversity.services;

import java.util.List;

import com.tutorial.contosouniversity.models.Student;

public interface StudentService {
	
	public Student create(Student student);
    public Student delete(int id);
    public List<Student> findAll();
    public Student update(Student student);
    public Student findById(int id);

}
