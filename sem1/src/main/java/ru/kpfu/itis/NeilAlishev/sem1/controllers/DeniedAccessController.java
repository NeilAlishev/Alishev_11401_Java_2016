package ru.kpfu.itis.NeilAlishev.sem1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Controller
public class DeniedAccessController {
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String getAccessDeniedPage() {
        return "403";
    }

}
