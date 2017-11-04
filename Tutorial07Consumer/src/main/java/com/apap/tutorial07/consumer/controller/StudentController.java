package com.apap.tutorial07.consumer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tutorial07.consumer.model.CourseModel;
import com.apap.tutorial07.consumer.model.StudentModel;
import com.apap.tutorial07.consumer.service.StudentService;



@Controller
public class StudentController
{
	   @Autowired
	    StudentService studentDAO;

	    @RequestMapping("/")
	    public String index ()
	    {
	        return "index";
	    }


	    @RequestMapping("/student/add")
	    public String add ()
	    {
	        return "form-add";
	    }


	    @RequestMapping("/student/add/submit")
	    public String addSubmit (
	            @RequestParam(value = "npm", required = false) String npm,
	            @RequestParam(value = "name", required = false) String name,
	            @RequestParam(value = "gpa", required = false) double gpa)
	    {
	        StudentModel student = new StudentModel (npm, name, gpa,null);
	        studentDAO.addStudent (student);

	        return "success-add";
	    }


	    @RequestMapping("/student/view")
	    public String view (Model model,
	            @RequestParam(value = "npm", required = false) String npm)
	    {
	        StudentModel student = studentDAO.selectStudent (npm);

	        if (student != null) {
	            model.addAttribute ("student", student);
	            return "view";
	        } else {
	            model.addAttribute ("npm", npm);
	            return "not-found";
	        }
	    }

	    

	    @RequestMapping("/student/view/{npm}")
	    public String viewPath (Model model,
	            @PathVariable(value = "npm") String npm)
	    {
	        StudentModel student = studentDAO.selectStudent (npm);

	        if (student != null) {
	            model.addAttribute ("student", student);
	            return "view";
	        } else {
	            model.addAttribute ("npm", npm);
	            return "not-found";
	        }
	    }

	    @RequestMapping("/course/view/{id}")
	    public String viewCourse(Model model,
	    		@PathVariable(value = "id") String id)
	    {
	        CourseModel course = studentDAO.selectCourse(id);
	        model.addAttribute ("course",course);
	        return "viewcourse";
	    }
	    
	    @RequestMapping("/student/viewall")
	    public String viewStudent(Model model)
	    {
	        List<StudentModel> students = studentDAO.selectAllStudents ();
	        model.addAttribute ("students", students);
	        
	        return "viewall";
	    }
	   
	    @RequestMapping("/course/viewall")
	    public String viewCourse(Model model)
	    {
	        List<CourseModel> courses = studentDAO.selectAllCourses();
	        model.addAttribute("courses", courses);
	        
	        return "viewallcourses";
	    }
	    @RequestMapping("/student/delete/{npm}")
	    public String delete (Model model, @PathVariable(value = "npm") String npm)
	    {
	    	StudentModel student = studentDAO.selectStudent (npm);

	        if (student != null) {
	        	studentDAO.deleteStudent (npm);
	        	model.addAttribute ("student", student);
	            return "delete";
	        } 
	        model.addAttribute ("npm", npm);
	        return "not-found";
	    }
	    
	    
	    @RequestMapping("/student/update/{npm}")
	    public String update (Model model, @PathVariable(value = "npm") String npm)
	    {
	    	StudentModel student = studentDAO.selectStudent (npm);

	        if (student != null) {
	        	model.addAttribute ("student", student);
	            return "form-update";
	        } 
	        model.addAttribute ("npm", npm);
	        return "not-found";
	    }
	    
	    @RequestMapping(value = "/student/update/submit", method = RequestMethod.POST)
	    public String updateSubmit(@Valid @ModelAttribute StudentModel student)
	    {
	    	studentDAO.updateStudent(student.getNpm(), student.getName(), student.getGpa());
	    	return "success-update";
	    }
	    
	    @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	    }
	    
	  
	   
	}
