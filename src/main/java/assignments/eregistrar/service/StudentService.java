package assignments.eregistrar.service;


import assignments.eregistrar.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> findAll();
    Student findById(Long id);
    void update(Student student);
    void deleteById(Long id);
    List<Student> search(String searchString);
    Page<Student> findAllStudents(int pageNo);
}
