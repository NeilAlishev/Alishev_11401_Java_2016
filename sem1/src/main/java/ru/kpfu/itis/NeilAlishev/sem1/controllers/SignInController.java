package ru.kpfu.itis.NeilAlishev.sem1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Controller
public class SignInController {
    @RequestMapping(value = "/sign_in", method = RequestMethod.GET)
    public String signInPage(@RequestParam(value = "error", required = false) Boolean error, Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        return "sign_in";
    }

    @RequestMapping(value = "/choice", method = RequestMethod.GET)
    public String chooseSignUp() {
        return "choose_sign_up";
    }
}

