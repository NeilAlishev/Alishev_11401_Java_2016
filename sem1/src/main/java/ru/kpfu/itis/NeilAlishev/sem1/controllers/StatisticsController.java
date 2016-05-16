package ru.kpfu.itis.NeilAlishev.sem1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.NeilAlishev.sem1.models.Student;
import ru.kpfu.itis.NeilAlishev.sem1.models.User;
import ru.kpfu.itis.NeilAlishev.sem1.models.enums.Role;
import ru.kpfu.itis.NeilAlishev.sem1.service.StudentService;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Controller
public class StatisticsController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public String showStatistics(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("current_user", user);
        Student currentStudent = studentService.getOne(user.getId());

        if(user.getRole().equals(Role.ROLE_STUDENT))
            model.addAttribute("homework", currentStudent.getGroup().getHomeworks());

        return "student/statistics";
    }
}
