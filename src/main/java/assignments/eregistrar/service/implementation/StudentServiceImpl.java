package assignments.eregistrar.service.implementation;

import assignments.eregistrar.service.StudentService;
import assignments.eregistrar.entity.Student;
import assignments.eregistrar.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> search(String searchString) {
        return studentRepository.findAllByStudentNumberOrFirstNameOrMiddleNameOrLastName(searchString, searchString, searchString, searchString);
    }

    @Override
    public Page<Student> findAllStudents(int pageNo) {
        return studentRepository.findAll(PageRequest.of(pageNo, 5, Sort.by(Sort.Direction.ASC, "firstName")));
    }
}
