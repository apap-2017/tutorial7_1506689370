package com.apap.tutorial07.consumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.apap.tutorial07.consumer.dao.StudentDAO;
import com.apap.tutorial07.consumer.model.CourseModel;
import com.apap.tutorial07.consumer.model.StudentModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Primary
public class StudentServiceRest implements StudentService{

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public StudentModel selectStudent(String npm) {
		log.info("REST - select student with npm{}", npm);
		return studentDAO.selectStudent(npm);
	}

	@Override
	public List<StudentModel> selectAllStudents() {
		log.info("REST - select all students");
		return studentDAO.selectAllStudents();
	}

	@Override
	public void addStudent(StudentModel student) {}
	
	@Override
	public void deleteStudent(String npm) {}

	@Override
	public void updateStudent(String npm, String name, Double gpa) {}

	@Override
	public List<CourseModel> selectCourses(String npm) {
		return null;
	}

	@Override
	public CourseModel selectCourse(String id_course) {
		log.info ("REST - select course with id {}", id_course);
		 return studentDAO.selectCourse(id_course);
	}

	@Override
	public List<StudentModel> selectStudentsFromCourse(String id_course) {
		return null;
	}

	@Override
	public List<CourseModel> selectAllCourses() {
		log.info("REST - select all courses");
		return studentDAO.selectAllCourses();
	}

}
