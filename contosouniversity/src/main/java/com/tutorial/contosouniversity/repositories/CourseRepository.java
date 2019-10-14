package com.tutorial.contosouniversity.repositories;

import com.tutorial.contosouniversity.models.Course;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {

}
