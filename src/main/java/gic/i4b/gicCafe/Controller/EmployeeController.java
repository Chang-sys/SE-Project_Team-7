package gic.i4b.gicCafe.Controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gic.i4b.gicCafe.Models.Employee;
import gic.i4b.gicCafe.Repository.EmployeeRepository;
import gic.i4b.gicCafe.Service.EmployeeService;

@RestController
public class EmployeeController {
    private EmployeeRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmployeeService service;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/admin/create_employee")
    public Object create_employee() {
        return new ModelAndView("newCashier");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/admin/view_employee")
    public Object view_cashier() {
        ModelAndView modelAndView = new ModelAndView("list_employee");
        modelAndView.addObject("employee", service.getemployees());
        return modelAndView;
    }

    // @PreAuthorize("hasAuthority('ADMIN')")
    // @PostMapping("/create_employee")
    // public String create_employee(@ModelAttribute Employee form, @RequestParam(value = "image") MultipartFile image,
    //         RedirectAttributes redirectAttributes) throws Exception {

    //     Employee cashier = new Employee();
    //     cashier.setFirstname(form.getFirstname());
    //     cashier.setLastname(form.getLastname());
    //     cashier.setDob(form.getDob());
    //     cashier.setSex(form.getSex());
    //     cashier.setUsername(form.getUsername());
    //     cashier.setRole(form.getRole());
    //     cashier.setPassword(form.getPassword());
    //     cashier.setImage_path(image.getOriginalFilename());

    //     if (!image.getOriginalFilename().equals("")) {
    //         Employee uploading = service.saveemployee(cashier);

    //         if (uploading != null) {
    //             try {
    //                 File saveFile = new ClassPathResource("assets/employeeImge").getFile();
    //                 Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + image.getOriginalFilename());
    //                 Files.write(path, image.getBytes());
    //             } catch (Exception e) {
    //                 // TODO: handle exception
    //             }
    //         }

    //         redirectAttributes.addFlashAttribute("successMessage", "Create cashier successfully!");

    //     } else {
    //         redirectAttributes.addFlashAttribute("errorMessage", "Create cashier failed!");
    //     }

    //     return "redirect:/admin/create_employee";
    // }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/get_employee")
    public List<Employee> get_employee() {
        return service.getemployees();
    }

}