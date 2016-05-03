package ru.kpfu.itis.NeilAlishev.sem1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.NeilAlishev.sem1.models.Group;
import ru.kpfu.itis.NeilAlishev.sem1.models.Teacher;
import ru.kpfu.itis.NeilAlishev.sem1.models.User;
import ru.kpfu.itis.NeilAlishev.sem1.service.GroupService;
import ru.kpfu.itis.NeilAlishev.sem1.service.TeacherService;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Controller
@RequestMapping("/teacher")
public class TeachersController {

    @Autowired
    GroupService groupService;

    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public String showGroups(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("current_user", user);
        Teacher currentTeacher = teacherService.getTeacherByID(user.getId());
        model.addAttribute("groups", groupService.findAllByTeacher(currentTeacher));
        return "teacher/groups";
    }

    @RequestMapping(value = "/groups/add", method = RequestMethod.GET)
    public String showAddGroupPage(Model model) {
        model.addAttribute("groups", groupService.findAll());
        return "teacher/addGroup";
    }

    @RequestMapping(value = "/groups/add", method = RequestMethod.POST)
    public String addGroups(Model model, @RequestParam(value = "group") String group) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Group current_group = groupService.findByName(group);
        Teacher current_teacher = teacherService.getTeacherByID(user.getId());
        if (current_teacher.getGroups().contains(current_group)) {
            model.addAttribute("error", "Вы уже добавляли эту группу");
            model.addAttribute("groups", groupService.findAll());
            return "/teacher/addGroup";
        }
        current_teacher.getGroups().add(current_group);
        teacherService.add(current_teacher);
        return "redirect:/teacher/groups";
    }
}
