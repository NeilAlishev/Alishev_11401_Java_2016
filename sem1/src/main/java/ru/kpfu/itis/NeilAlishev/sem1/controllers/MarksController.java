package ru.kpfu.itis.NeilAlishev.sem1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.NeilAlishev.sem1.service.GroupService;
import ru.kpfu.itis.NeilAlishev.sem1.service.MarkService;

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

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getNewMark(Model model) {
        model.addAttribute("groups", groupService.findAll());
        return "marks/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createNewMark() {
        return null;
    }

}
