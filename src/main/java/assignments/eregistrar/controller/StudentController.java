package assignments.eregistrar.controller;

import assignments.eregistrar.service.StudentService;
import assignments.eregistrar.entity.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/eregistrar/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public ModelAndView findAll(@RequestParam(defaultValue = "0") int pageNo){
        ModelAndView modelAndView = new ModelAndView();
        Page<Student> students = studentService.findAllStudents(pageNo);
        modelAndView.addObject("currentPageNo", pageNo);
        modelAndView.addObject("students", students);
        modelAndView.setViewName("students");
        return modelAndView;
    }

    @GetMapping("/new")
    public String displayNewStudentForm(Model model){
        model.addAttribute("student", new Student(null,null, null, null, null, null, null, null));
        return "addnew";
    }

    @PostMapping("/register")
    public String addNewStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model){
        System.out.println(student);
        if(bindingResult.hasErrors()){
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            System.out.println(bindingResult.getAllErrors());
            return "addnew";
        }
        studentService.saveStudent(student);
        return "redirect:/eregistrar/students";
    }

    @GetMapping("/edit/{studentId}")
    public String displayEditForm(@PathVariable Long studentId, Model model ){
        Student student = studentService.findById(studentId);
        if(student!=null){
            model.addAttribute("student", student);
            return "edit";
        }
        return "redirect:/eregistrar/students";
    }

    @PostMapping("/update")
    public String editStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "edit";
        }
        studentService.update(student);
        return "redirect:/eregistrar/students";
    }

    @GetMapping("/delete/{studentId}")
    public String delete(@PathVariable Long studentId){
        studentService.deleteById(studentId);
        return "redirect:/eregistrar/students";
    }

    @GetMapping(value = {"/search"})
    public ModelAndView search(@RequestParam String searchString){
        System.out.println(searchString);
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.search(searchString);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", searchString);
        modelAndView.setViewName("searchResult");
        return modelAndView;
    }

}
