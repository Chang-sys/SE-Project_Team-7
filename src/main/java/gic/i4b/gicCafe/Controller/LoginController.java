package gic.i4b.gicCafe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import gic.i4b.gicCafe.Service.EmployeeService;

@RestController
public class LoginController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/employee/login")
    public Object login() {
        return new ModelAndView("login");
    }

    @GetMapping(path = "/")
    public Object loginV2() {
        return new ModelAndView("login");
    }

}
