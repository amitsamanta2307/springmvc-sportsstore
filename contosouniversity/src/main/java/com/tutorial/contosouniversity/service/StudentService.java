package com.tutorial.contosouniversity.service;

import java.util.List;

import com.tutorial.contosouniversity.models.Student;
import com.tutorial.contosouniversity.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {

    @Autowired
    StudentRepository repository;

    public List<Student> getAll() {
        return (List<Student>) repository.findAll();
    }

    public Student getById(Integer id) {
        return repository.findById(id).get();
    }

    public void save(Student student) {
        repository.save(student);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}