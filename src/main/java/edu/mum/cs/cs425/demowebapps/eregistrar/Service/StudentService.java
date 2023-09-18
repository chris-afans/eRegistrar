package edu.mum.cs.cs425.demowebapps.eregistrar.Service;

import edu.mum.cs.cs425.demowebapps.eregistrar.Repository.StudentRepository;
import edu.mum.cs.cs425.demowebapps.eregistrar.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void saveStudent(Student s){
        studentRepository.save(s);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void deleteStudent(Student s){
        studentRepository.delete(s);
    }

    public void updateStudent(Long id){
        Student s = studentRepository.findById(id).orElseThrow();
        studentRepository.save(s);
    }
}
