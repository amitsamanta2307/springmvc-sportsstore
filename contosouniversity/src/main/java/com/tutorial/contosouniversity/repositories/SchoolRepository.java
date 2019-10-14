package com.tutorial.contosouniversity.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tutorial.contosouniversity.models.Course;

public interface SchoolRepository extends CrudRepository<Course, Integer> {

}
