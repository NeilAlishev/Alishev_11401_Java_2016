package ru.kpfu.itis.NeilAlishev.sem1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.NeilAlishev.sem1.models.Group;
import ru.kpfu.itis.NeilAlishev.sem1.models.Schedule;
import ru.kpfu.itis.NeilAlishev.sem1.models.Student;
import ru.kpfu.itis.NeilAlishev.sem1.models.User;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.GroupRepository;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.ScheduleRepository;
import ru.kpfu.itis.NeilAlishev.sem1.service.GroupService;
import ru.kpfu.itis.NeilAlishev.sem1.service.ScheduleService;
import ru.kpfu.itis.NeilAlishev.sem1.util.SchoolDay;

import javax.servlet.http.HttpServletRequest;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(value = "/schedule/add", method = RequestMethod.GET)
    public String getAddSchedule(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("current_user", user);
        model.addAttribute("groups", groupService.findAll());
        return "admin/addSchedule";
    }

    @RequestMapping(value = "schedule/add", method = RequestMethod.POST)
    public String addSchedule(Model model, HttpServletRequest request) {
        Group group = groupService.findByName(request.getParameter("group"));
        if (group.getSchedule() != null) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("current_user", user);
            model.addAttribute("groups", groupService.findAll());
            model.addAttribute("error", "Эта группа уже имеет расписание");
            return "/admin/addSchedule";
        }
        groupService.addScheduleToGroup(group, request);
        return null;
    }
}
