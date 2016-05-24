package ru.kpfu.itis.NeilAlishev.sem1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.NeilAlishev.sem1.models.Teacher;
import ru.kpfu.itis.NeilAlishev.sem1.service.TeacherService;
import ru.kpfu.itis.NeilAlishev.sem1.util.*;

import javax.validation.Valid;


/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Controller
public class TeachersSignUpController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherValidator teacherValidator;


    @RequestMapping(value = "/teachers/sign_up", method = RequestMethod.GET)
    public String getSignUp(Model model) {
        model.addAttribute("teacher", new TeacherRegistrationForm());
        return "teacher/sign_up";
    }

    @RequestMapping(value = "/teachers/sign_up", method = RequestMethod.POST)
    public String signUp(Model model, @ModelAttribute("teacher") @Valid TeacherRegistrationForm teacherRegistrationForm,
                         BindingResult result) {
        teacherValidator.validate(teacherRegistrationForm, result);
        if (result.hasErrors()) {
            return "teacher/sign_up";
        }
        Teacher teacher = TeacherRegistrationFormToTeacherTransformer
                .transform(teacherRegistrationForm);
        teacherService.add(teacher);
        return "redirect:/sign_in";
    }
}
