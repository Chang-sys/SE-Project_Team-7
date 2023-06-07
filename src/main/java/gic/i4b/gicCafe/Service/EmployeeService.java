package gic.i4b.gicCafe.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import gic.i4b.gicCafe.Models.Employee;
import gic.i4b.gicCafe.Repository.EmployeeRepository;


@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Employee saveemployee(Employee employee) throws Exception{
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return repository.save(employee);
    }

    public List<Employee> getemployees(){
        return repository.findAll();
    }

    public Employee getemployeeById(Long id){
        return repository.getById(id);
    }

}
