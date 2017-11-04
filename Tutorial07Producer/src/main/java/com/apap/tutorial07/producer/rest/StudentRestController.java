package com.apap.tutorial07.producer.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apap.tutorial07.producer.model.CourseModel;
import com.apap.tutorial07.producer.model.StudentModel;
import com.apap.tutorial07.producer.service.StudentService;

@RestController
@RequestMapping("/rest")
public class StudentRestController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/student/view/{npm}")
	public StudentModel viewStudent(@PathVariable(value = "npm") String npm) {
		
		StudentModel student = studentService.selectStudent(npm);
		return student;
	
	}
	
	@RequestMapping("/student/viewall")
	public List<StudentModel> viewAllStudents() {
		
		List<StudentModel> studentList = studentService.selectAllStudents();
		return studentList;
	
	}
	
	@RequestMapping("/course/view/{id}")
	public CourseModel viewCourse(@PathVariable(value = "id") String id) {
		
		CourseModel course = studentService.selectCourse(id);
		return course;
	
	}
	
	@RequestMapping("/course/viewall")
	public List<CourseModel> viewAllCourses() {
		
		List<CourseModel> courseList = studentService.selectAllCourses();
		return courseList;
	
	}
}
