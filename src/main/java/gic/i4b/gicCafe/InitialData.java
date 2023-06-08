package gic.i4b.gicCafe;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import gic.i4b.gicCafe.Models.Employee;
import gic.i4b.gicCafe.Repository.EmployeeRepository;


@Component
public class InitialData implements CommandLineRunner{

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
            
        if ( repository.findAll().isEmpty() ){
            Employee admin = new Employee("Admin", "Chang", "ADMIN", "Male", "1999-01-01", "Admin", passwordEncoder.encode(("123")), null);
            Employee Employee = new Employee("Jack", "Man", "CASHIER", "Male", "2002-10-10", "Jack", passwordEncoder.encode(("123")), null) ;
            repository.saveAll(List.of(admin,Employee));
            System.out.println("User has been saved into database successfully :)");
        }else{
            System.out.println("User has been saved into database successfully :)");
        } 
        
    }
    
}
