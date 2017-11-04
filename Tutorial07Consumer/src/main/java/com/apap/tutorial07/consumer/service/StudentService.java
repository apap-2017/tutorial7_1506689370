package com.apap.tutorial07.consumer.service;

import java.util.List;

import com.apap.tutorial07.consumer.model.CourseModel;
import com.apap.tutorial07.consumer.model.StudentModel;


public interface StudentService
{
    StudentModel selectStudent (String npm);

    List<StudentModel> selectAllStudents ();
    
    void addStudent (StudentModel student);

    void deleteStudent (String npm);
    
    void updateStudent (String npm, String name, Double gpa );

	List<CourseModel> selectCourses(String npm);

	CourseModel selectCourse(String id_course);

	List<StudentModel> selectStudentsFromCourse(String id_course);

	List<CourseModel> selectAllCourses();




}
