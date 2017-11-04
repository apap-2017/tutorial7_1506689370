package com.apap.tutorial07.consumer.dao;

import java.util.List;

import com.apap.tutorial07.consumer.model.CourseModel;
import com.apap.tutorial07.consumer.model.StudentModel;

public interface StudentDAO {
	StudentModel selectStudent(String npm);
	List<StudentModel> selectAllStudents();
	CourseModel selectCourse(String id_course);
	List<CourseModel> selectAllCourses();
}
