package com.tutorial.contosouniversity.repositories;

import com.tutorial.contosouniversity.models.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
