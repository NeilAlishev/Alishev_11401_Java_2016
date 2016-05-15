package ru.kpfu.itis.NeilAlishev.sem1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.NeilAlishev.sem1.service.HomeworkService;

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
        System.out.println(request.getParameter("id"));
        System.out.println(request.getParameter("subject"));
        System.out.println(request.getParameter("message"));
//        if (homeworkService.saveHomework(request)) {
//            return ResponseEntity.ok(null);
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
        return ResponseEntity.ok("Homework was added");
    }
}
