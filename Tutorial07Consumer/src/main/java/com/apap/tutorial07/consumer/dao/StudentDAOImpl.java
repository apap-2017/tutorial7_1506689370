package com.apap.tutorial07.consumer.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apap.tutorial07.consumer.model.CourseModel;
import com.apap.tutorial07.consumer.model.StudentModel;

@Service
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public StudentModel selectStudent(String npm) {
		StudentModel student = restTemplate.getForObject("http://localhost:8080/rest/student/view/"+npm, StudentModel.class);
		return student;
	}

	@Override
	public List<StudentModel> selectAllStudents() {
		List<StudentModel> students = (List<StudentModel>)restTemplate.getForObject("http://localhost:8080/rest/student/viewall", List.class);
		return students;
	}

	
	@Override
	public CourseModel selectCourse(String id_course) {
		CourseModel course = restTemplate.getForObject("http://localhost:8080/rest/course/view/"+id_course, CourseModel.class);
		return course;
	}

	@Override
	public List<CourseModel> selectAllCourses() {
		List<CourseModel> courses = (List<CourseModel>)restTemplate.getForObject("http://localhost:8080/rest/course/viewall", List.class);
		return courses;
	}

	

}
