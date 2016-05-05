package ru.kpfu.itis.NeilAlishev.sem1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.NeilAlishev.sem1.models.User;
import ru.kpfu.itis.NeilAlishev.sem1.models.enums.Role;
import ru.kpfu.itis.NeilAlishev.sem1.service.StudentService;
import ru.kpfu.itis.NeilAlishev.sem1.service.TeacherService;

/**
 * Nail Alishev
 * 11-401
 * sem1
 */
@Controller
public class HomeController {

    @Autowired
    TeacherService teacherService;
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("current_user", user);
        if (user.getRole().equals(Role.ROLE_ADMIN)) {
            model.addAttribute("number_of_teachers", teacherService.getTeachers().size());
            model.addAttribute("number_of_students", studentService.getAll().size());
        }
        return "index";
    }
}
