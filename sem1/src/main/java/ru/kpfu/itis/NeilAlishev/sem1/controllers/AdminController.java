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
import ru.kpfu.itis.NeilAlishev.sem1.models.User;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.GroupRepository;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.ScheduleRepository;
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
    private GroupRepository groupRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @RequestMapping(value = "/schedule/add", method = RequestMethod.GET)
    public String getAddSchedule(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("current_user", user);
        model.addAttribute("groups", groupRepository.findAll());
        return "admin/addSchedule";
    }

    @RequestMapping(value = "schedule/add", method = RequestMethod.POST)
    public String addSchedule(Model model, HttpServletRequest request) {
        Schedule currentSchedule = new Schedule();
        Group group = groupRepository.findOneByName(request.getParameter("group"));
        if (group.getSchedule() != null) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("current_user", user);
            model.addAttribute("groups", groupRepository.findAll());
            model.addAttribute("error", "Эта группа уже имеет расписание");
            return "/admin/addSchedule";
        }

        setSchoolDays(currentSchedule, request);
        group.setSchedule(currentSchedule);
        currentSchedule.setGroup(group);
        scheduleRepository.save(currentSchedule);
        groupRepository.save(group);
//        System.out.println(request.getParameter("group"));
//        System.out.println(request.getParameter("0[0]"));
//        System.out.println(request.getParameter("1[0]"));
//        System.out.println(request.getParameter("2[0]"));
//        System.out.println(request.getParameter("3[0]"));
//        System.out.println(request.getParameter("4[0]"));
//        System.out.println(request.getParameter("5[0]"));
        return null;
    }

    private void setSchoolDays(Schedule schedule, HttpServletRequest request) {
        for (int i = 0; i < 6; i++) {                                            // Days of the week
            List<String> lessons = new ArrayList<>();
            for (int j = 0; j < 10; j++) {                                     // Lessons
                String lesson = request.getParameter(i + "[" + j + "]");

                if (lesson == null || lesson.equals(""))
                    break;

                lessons.add(lesson);

            }
            schedule.getSchoolDays().add(new SchoolDay(DayOfWeek.of(i + 1), lessons.toArray(new String[lessons.size()])));
        }
    }
}
