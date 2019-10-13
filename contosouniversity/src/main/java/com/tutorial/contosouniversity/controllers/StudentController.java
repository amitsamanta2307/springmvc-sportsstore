package com.tutorial.contosouniversity.controllers;

import java.util.List;

import com.tutorial.contosouniversity.models.Student;
import com.tutorial.contosouniversity.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ModelAndView index() {
        List<Student> list = studentService.getAll();
        ModelAndView mav = new ModelAndView("/student/index");
        mav.addObject("students", list);
        return mav;
    }

    @RequestMapping(value = "/student/details/{id}")
    public ModelAndView details(@PathVariable("id") int id) {
        Student stu = studentService.getById(id);
        ModelAndView mav = new ModelAndView("/student/details");
        mav.addObject("student", stu);
        return mav;
    }
}