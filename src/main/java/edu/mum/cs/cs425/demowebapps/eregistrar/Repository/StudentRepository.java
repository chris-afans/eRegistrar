package edu.mum.cs.cs425.demowebapps.eregistrar.Repository;

import edu.mum.cs.cs425.demowebapps.eregistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
