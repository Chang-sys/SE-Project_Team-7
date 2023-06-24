package gic.i4b.gicCafe.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class DrinkController {
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/admin/list_drink")
    public Object list_drink() {
        return new ModelAndView("drinkMenu");
    }
}
