package com.apap.tutorial07.consumer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.apap.tutorial07.consumer.model.CourseModel;
import com.apap.tutorial07.consumer.model.StudentModel;

import org.apache.ibatis.annotations.Many;


@Mapper
public interface StudentMapper
{
    @Select("select npm, name, gpa from student where npm = #{npm}")
    @Results(value= {
    		@Result(property="npm",column="npm"),
    		@Result(property="name",column="name"),
    		@Result(property="gpa",column="gpa"),
    		@Result(property="courses",column="npm", javaType=List.class, many=@Many(select="selectCourses"))
    })
    StudentModel selectStudent (@Param("npm") String npm);
    
    @Select("select npm, name, gpa from student")
    @Results(value= {
    		@Result(property="npm",column="npm"),
    		@Result(property="name",column="name"),
    		@Result(property="gpa",column="gpa"),
    		@Result(property="courses",column="npm", javaType=List.class, many=@Many(select="selectCourses"))
    })
    List<StudentModel> selectAllStudents ();
    
    @Insert("INSERT INTO student (npm, name, gpa) VALUES (#{npm}, #{name}, #{gpa})")
    void addStudent (StudentModel student);
    
    @Delete("DELETE FROM student WHERE npm = #{npm}")
    void deleteStudent (@Param("npm") String npm);
    
    @Update("UPDATE student SET name = #{name},gpa = #{gpa} WHERE npm = #{npm}")
    void updateStudent (@Param("npm") String npm,@Param("name") String name,@Param("gpa") Double gpa);

    @Select("select course.id_course, name, credits from studentcourse join course on studentcourse.id_course = course.id_course where studentcourse.npm = #{npm}")
    @Results(value= {
    		@Result(property="idCourse",column="id_course"),
    		@Result(property="name",column="name"),
    		@Result(property="credits",column="credits")
    })
    List<CourseModel> selectCourses(@Param("npm")String npm);
    
    @Select("select id_course, name, credits from course where id_course = #{id}")
    @Results(value= {
    		@Result(property="idCourse",column="id_course"),
    		@Result(property="name",column="name"),
    		@Result(property="credits",column="credits"),
    		@Result(property="students",column="id_course", javaType=List.class, many=@Many(select="selectStudentsFromCourse"))
    })
    CourseModel selectCourse(@Param("id")String id);
    
    @Select("select student.npm, student.name, gpa from studentcourse join student on studentcourse.npm = student.npm where studentcourse.id_course= #{id}")
    List<StudentModel> selectStudentsFromCourse(@Param("id")String id);
}
