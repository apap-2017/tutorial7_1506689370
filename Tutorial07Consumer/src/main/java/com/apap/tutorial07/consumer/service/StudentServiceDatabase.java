package com.apap.tutorial07.consumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial07.consumer.dao.StudentMapper;
import com.apap.tutorial07.consumer.model.CourseModel;
import com.apap.tutorial07.consumer.model.StudentModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceDatabase implements StudentService
{
    @Autowired
    private StudentMapper studentMapper;


    @Override
    public StudentModel selectStudent (String npm)
    {
        log.info ("select student with npm {}", npm);
        return studentMapper.selectStudent (npm);
    }


    @Override
    public List<StudentModel> selectAllStudents ()
    {
        log.info ("select all students");
        return studentMapper.selectAllStudents ();
    }



    @Override
    public void addStudent (StudentModel student)
    {
        studentMapper.addStudent (student);
    }


    @Override
    public void deleteStudent (String npm)
    {
    	log.info("student " + npm + " deleted");
    	studentMapper.deleteStudent(npm);
    }


	@Override
	public void updateStudent(String npm, String name, Double gpa) {
		log.info("student " + npm + " updated");
		studentMapper.updateStudent(npm, name, gpa);
		
	}


	@Override
	public CourseModel selectCourse(String id_course) {
		log.info ("select course with id {}", id_course);
	    return studentMapper.selectCourse(id_course);
	}


	@Override
	public List<CourseModel> selectCourses(String npm) {
		log.info ("select courses from student with npm {}", npm);
        return studentMapper.selectCourses(npm);
	}


	@Override
	public List<StudentModel> selectStudentsFromCourse(String id_course) {
		log.info ("select students in course with id {}", id_course);
        return studentMapper.selectStudentsFromCourse(id_course);
	}


	@Override
	public List<CourseModel> selectAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}



}
