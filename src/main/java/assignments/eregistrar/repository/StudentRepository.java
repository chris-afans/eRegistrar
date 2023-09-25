package assignments.eregistrar.repository;

import assignments.eregistrar.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByStudentNumberOrFirstNameOrMiddleNameOrLastName(String studentNumber, String firstName, String middleName, String lastName);


}
