package gic.i4b.gicCafe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class gicCafeController {
    @GetMapping(path = "/login")
    public ModelAndView task1(){
        return new ModelAndView("login");
    }

    @GetMapping(path = "/tableSelect")
    public ModelAndView tableSelect(){
        return new ModelAndView("tableSelect");
    }
}
