package com.barone.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeFormController {

    @RequestMapping(value = "/employeeform")
    public String getView(Model model) {
        model.addAttribute("employee", new Employee("", ""));
        return "employeeform";
    }

//    @RequestMapping(value = "/addemployee", method = RequestMethod.POST)
//    public String getEmployee(Model model) {
//        model.addAttribute("employee", new Employee("Kalle", "1"));
//        return "newemployee";
//    }

    @RequestMapping(value = "/addemployee", method = RequestMethod.POST)
    public ModelAndView getEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        model.addAttribute("employee", employee);
        return new ModelAndView("/employeeform", model.asMap());
    }

}
