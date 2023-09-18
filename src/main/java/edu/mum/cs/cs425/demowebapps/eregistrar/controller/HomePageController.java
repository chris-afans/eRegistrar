package edu.mum.cs.cs425.demowebapps.eregistrar.controller;

import edu.mum.cs.cs425.demowebapps.eregistrar.Service.StudentService;
import edu.mum.cs.cs425.demowebapps.eregistrar.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = {"/", "/eregistrar", "/eregistrar/home"})
    public String displayHomePage(){
        return "Home/index";
    }

    @GetMapping({"/studentList"})
    public List<Student> getAllEmployees() {
       return studentService.getAllStudents();
    }
}
