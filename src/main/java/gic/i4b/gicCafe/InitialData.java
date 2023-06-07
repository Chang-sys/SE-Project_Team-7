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

    // @Autowired
    // private TableRepository tableRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
            
        if ( repository.findAll().isEmpty() ){
            Employee admin = new Employee("Admin", "Chang", "ADMIN", "Male", "1999-01-01", "Admin", passwordEncoder.encode(("1234")), null);
            Employee Employee = new Employee("Jack", "Man", "CASHIER", "Male", "2002-10-10", "Jack", passwordEncoder.encode(("1234")), null) ;
            repository.saveAll(List.of(admin,Employee));
            System.out.println("User has been saved into database successfully :)");
        }else{
            System.out.println("User has been saved into database successfully :)");
        } 

        // if (tableRepository.findAll().isEmpty()){
        //     Tables table1 = new Tables(true, 0, 1);
        //     Tables table2 = new Tables(true, 0, 2);
        //     Tables table3 = new Tables(true, 0, 3);
        //     Tables table4 = new Tables(true, 0, 4);
        //     Tables table5 = new Tables(true, 0, 5);
        //     Tables table6 = new Tables(true, 0, 6);
        //     Tables table7 = new Tables(true, 0, 7);
        //     Tables table8 = new Tables(true, 0, 8);
        //     Tables table9 = new Tables(true, 0, 9);
        //     Tables table10 = new Tables(true, 0, 10);
        //     Tables table11 = new Tables(true, 0, 11);
        //     Tables table12 = new Tables(true, 0, 12);
        //     tableRepository.saveAll(List.of(table1,table2,table3,table4,table5,table6,table7,table8,table9,table10,table11,table12));
        //     System.out.println("Table initialize succesfully! - Table has been saved to database.");
        // }else{
        //     System.out.println("Table is initilized.");
        // }
        

    }
    
}
