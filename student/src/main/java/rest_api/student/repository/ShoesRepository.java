package rest_api.student.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import rest_api.student.controller.Shoes;
public interface ShoesRepository extends JpaRepository<Shoes,Long>{
    
}
