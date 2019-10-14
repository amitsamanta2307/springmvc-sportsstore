package com.tutorial.contosouniversity.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.contosouniversity.models.Student;
import com.tutorial.contosouniversity.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Resource
	private StudentRepository studentRepository;

	@Override
	@Transactional
	public Student create(Student student) {
		Student entity = student;
		return studentRepository.save(entity);
	}

	@Override
	@Transactional
	public Student delete(int id) {
		Optional<Student> entity = studentRepository.findById(id);
		
		if (!entity.isPresent()) {
			return null;
		}
		
		studentRepository.delete(entity.get());
		return entity.get();
	}

	@Override
	@Transactional
	public List<Student> findAll() {
		List<Student> students = new ArrayList<Student>();
		Iterable<Student> iterable = studentRepository.findAll();
		iterable.forEach(students::add);
		
		return students;
	}

	@Override
	@Transactional
	public Student update(Student student) {
		Optional<Student> entity = studentRepository.findById(student.getId());
		
		if (!entity.isPresent()) {
			return null;
		}
		
		entity.get().setFirstMidName(student.getFirstMidName());
		entity.get().setLastName(student.getLastName());
		entity.get().setEnrollmentDate(student.getEnrollmentDate());
		
		return entity.get();
	}

	@Override
	@Transactional
	public Student findById(int id) {
		Optional<Student> entity = studentRepository.findById(id);
		return entity.isPresent() ? entity.get() : null;
	}

}
