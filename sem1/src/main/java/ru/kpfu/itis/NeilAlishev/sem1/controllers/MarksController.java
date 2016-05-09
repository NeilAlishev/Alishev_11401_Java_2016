package ru.kpfu.itis.NeilAlishev.sem1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.NeilAlishev.sem1.models.Teacher;
import ru.kpfu.itis.NeilAlishev.sem1.models.User;
import ru.kpfu.itis.NeilAlishev.sem1.service.GroupService;
import ru.kpfu.itis.NeilAlishev.sem1.service.MarkService;
import ru.kpfu.itis.NeilAlishev.sem1.service.TeacherService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Controller
@RequestMapping("/marks")
public class MarksController {

    @Autowired
    GroupService groupService;

    @Autowired
    MarkService markService;

    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getNewMark(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Teacher currentTeacher = teacherService.getTeacherByID(user.getId());
        model.addAttribute("groups", groupService.findAllByTeacher(currentTeacher));
        return "marks/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createNewMark(Model model, HttpServletRequest request) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Teacher currentTeacher = teacherService.getTeacherByID(user.getId());
        model.addAttribute("groups", groupService.findAllByTeacher(currentTeacher));
        if (request.getParameter("subject").equals("") || request.getParameter("date").equals("")) {
            model.addAttribute("error", "Все поля должны быть заполнены!");
        } else {
            markService.addMark(currentTeacher, request);
            model.addAttribute("info", "Вы успешно поставили оценку");
        }
        return "marks/new";
    }
}
