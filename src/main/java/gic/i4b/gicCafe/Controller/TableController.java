package gic.i4b.gicCafe.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TableController {
    
    @GetMapping(path = "/employee/tableSelection")
    public ModelAndView tableSelect(){
        return new ModelAndView("tableSelect");
    }

    @GetMapping(path = "/employee/invoice")
    public ModelAndView invoice(){
        return new ModelAndView("invoice");
    }
}
