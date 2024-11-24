package rest_api.student.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import rest_api.student.controller.Student;
public interface StudentRepository extends JpaRepository<Student,Long> {
    
}
