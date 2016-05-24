package ru.kpfu.itis.NeilAlishev.sem1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.NeilAlishev.sem1.models.User;
import ru.kpfu.itis.NeilAlishev.sem1.service.HomeworkService;
import ru.kpfu.itis.NeilAlishev.sem1.service.TeacherService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Controller
@RequestMapping(value = "/homeworks")
public class HomeworksController {
    @Autowired
    HomeworkService homeworkService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<String> createHomework(HttpServletRequest request) {
        User currentTeacher = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (homeworkService.saveHomework(request, currentTeacher.getId())) {
            return ResponseEntity.ok("Домашняя работа была добавлена");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Проверьте правильность заполнения полей");
        }
    }
}
