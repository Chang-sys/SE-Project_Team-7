package gic.i4b.gicCafe.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomepageController {
    @GetMapping(path = "/employee/homepage")
    public Object obj(){
        return new ModelAndView("home");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/admin/homepage")
    public Object admin_home(){
        return new ModelAndView("adminHome");
    }
}
