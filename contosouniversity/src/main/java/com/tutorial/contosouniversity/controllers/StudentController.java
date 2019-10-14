package com.tutorial.contosouniversity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tutorial.contosouniversity.models.Student;
import com.tutorial.contosouniversity.services.StudentServiceImpl;

@Controller
@RequestMapping(value = "/students")
public class StudentController {
	
	@Autowired
    private StudentServiceImpl studentService;
	
	@GetMapping("/list")
	public ModelAndView index() {
		List<Student> students = studentService.findAll();
        ModelAndView mav = new ModelAndView("/student/list");
        mav.addObject("students", students);
        return mav;
	}
	
	@GetMapping("/create")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView("/student/create", "student", new Student());
		return mav;
	}
	
	@PostMapping(value="/create")
    public ModelAndView createNewShop(@ModelAttribute Student student, 
            final RedirectAttributes redirectAttributes) {
 
        ModelAndView mav = new ModelAndView();
        String message = "New shop " + student.getFirstMidName() + " was successfully created.";
 
        studentService.create(student);
        mav.setViewName("redirect:/student/list.html");
 
        redirectAttributes.addFlashAttribute("message", message);   
        return mav;     
    }
	
	@GetMapping("/details/{id}")
	public ModelAndView details(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("/student/details");
        Student student = studentService.findById(id);
        mav.addObject("student", student);
        return mav;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("/student/edit");
        Student student = studentService.findById(id);
        mav.addObject("student", student);
        return mav;
	}
}
