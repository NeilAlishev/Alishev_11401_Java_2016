package ru.kpfu.itis.NeilAlishev.sem1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.NeilAlishev.sem1.models.Group;
import ru.kpfu.itis.NeilAlishev.sem1.models.Student;
import ru.kpfu.itis.NeilAlishev.sem1.models.User;
import ru.kpfu.itis.NeilAlishev.sem1.service.StudentService;
import ru.kpfu.itis.NeilAlishev.sem1.service.TeacherService;

/**
 * @author Nail Alishev
 *         11-401
 *         se1m
 */
@Controller
@RequestMapping("/student")
public class StudentsController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public String getTeachers(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("current_user", user);
        Student currentStudent = studentService.getOne(user.getId());
        Group currentGroup = currentStudent.getGroup();
        model.addAttribute("teachers", teacherService.findAllByGroup(currentGroup));
        return "student/teachers";
    }
}