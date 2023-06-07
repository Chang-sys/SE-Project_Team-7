package gic.i4b.gicCafe.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import gic.i4b.gicCafe.Models.Employee;
import gic.i4b.gicCafe.Repository.EmployeeRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Optional<Employee> cashierInfo = repository.findByUsername(username);
        
        return cashierInfo.map(UserInfoUserDetails::new)
            .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
    }
    
}
