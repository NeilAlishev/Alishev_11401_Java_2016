package ru.kpfu.itis.NeilAlishev.sem1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.NeilAlishev.sem1.models.Group;
import ru.kpfu.itis.NeilAlishev.sem1.models.Student;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.GroupRepository;
import ru.kpfu.itis.NeilAlishev.sem1.service.GroupService;
import ru.kpfu.itis.NeilAlishev.sem1.service.StudentService;
import ru.kpfu.itis.NeilAlishev.sem1.util.StudentRegistrationForm;
import ru.kpfu.itis.NeilAlishev.sem1.util.StudentRegistrationFormToStudentTransformer;
import ru.kpfu.itis.NeilAlishev.sem1.util.StudentValidator;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Controller
public class StudentsSignUpController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentValidator studentValidator;

    @Autowired
    private GroupService groupService;


    @RequestMapping(value = "/students/sign_up", method = RequestMethod.GET)
    public String getSignUp(Model model) {
        model.addAttribute("student", new StudentRegistrationForm());
        List<Group> groups = groupService.findAll();
        model.addAttribute("groups", groups);
        return "student/sign_up";
    }

    @RequestMapping(value = "/students/sign_up", method = RequestMethod.POST)
    public String signUp(Model model, @ModelAttribute("student") @Valid StudentRegistrationForm studentRegistrationForm,
                         BindingResult result) {
        studentValidator.validate(studentRegistrationForm, result);
        if (result.hasErrors()) {
            model.addAttribute("groups", groupService.findAll());
            return "student/sign_up";
        }
        Student student = StudentRegistrationFormToStudentTransformer
                .transform(studentRegistrationForm);
        Group group = groupService.findByName(studentRegistrationForm.getGroup());
        studentService.addStudent(student, group);
        return "redirect:/sign_in";
    }
}
