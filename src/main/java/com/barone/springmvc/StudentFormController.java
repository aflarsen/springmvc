package com.barone.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Controller
public class StudentFormController {

    private List<Student> students = new ArrayList<>();

    @RequestMapping(value = "/studentform")
    public String getView(@ModelAttribute("student") Student student, Model model) {
        students.add(new Student("Kalle", "1"));
        students.add(new Student("Malle", "2"));
        students.add(new Student("Lalle", "3"));
        students.add(new Student("Salle", "4"));
        model.addAttribute("students", students);
        return "studentform";
    }

    @RequestMapping(value = "/addChosenStudents", method = RequestMethod.POST)
    public ModelAndView getStudents(@ModelAttribute("student") Student student, Model model) {
        List<String> chosenStudentIdList = new ArrayList<>();
        if (student.getName().contains(",")) {
            chosenStudentIdList = Arrays.asList(student.getName().split(","));
        } else {
            chosenStudentIdList.add(student.getName());
        }
        List<Student> chosenStudents = new ArrayList<>();
        List<Student> chosenStudentsWithoutDuplicates = new ArrayList<>();
        for (Student studentItem : students) {
            if (chosenStudentIdList.contains(studentItem.getId())) {
                chosenStudents.add(studentItem);
                chosenStudentsWithoutDuplicates = new ArrayList<Student>(
                        new HashSet<>(chosenStudents));
            }
        }
        model.addAttribute("chosenStudents", chosenStudentsWithoutDuplicates);
        model.addAttribute("students", students);
        return new ModelAndView("/studentform", model.asMap());
    }

    @RequestMapping(value = "/addChosenStudent", method = RequestMethod.POST)
    public ModelAndView getChosenStudent(@ModelAttribute("student") Student chosenStudent, Model model) {
        model.addAttribute("chosenStudent", chosenStudent);
        return new ModelAndView("/studentform", model.asMap());
    }
}
