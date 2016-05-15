package ru.kpfu.itis.NeilAlishev.sem1.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.NeilAlishev.sem1.models.User;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Controller
public class StatisticsController {

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public String showStatistics(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("current_user", user);
        return "student/statistics";
    }
}
