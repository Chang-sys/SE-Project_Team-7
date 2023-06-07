package gic.i4b.gicCafe.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gic.i4b.gicCafe.Models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    Optional<Employee> findByUsername(String username);
    
}
