package ru.kpfu.itis.NeilAlishev.sem1.controllers;

import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.NeilAlishev.sem1.models.Student;
import ru.kpfu.itis.NeilAlishev.sem1.service.StudentsService;

import java.util.List;
import java.util.Map;

/**
 * Created by neil on 11.04.16.
 */
@Controller
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView getStudents() {
        // Just to check if it works...
        ModelAndView modelAndView = new ModelAndView("check");
        Map<String, Object> map = modelAndView.getModel();
        map.put("first_student", studentsService.getStudentByID(1).getName());
        return modelAndView;
    }

//    @RequestMapping("/{id}")
//    public Student getStudent(@PathVariable("id") int id) {
//        return studentRepository.findOne(id);
//    }
//
//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public ObjectNode addStudent(@ModelAttribute Student student) {
//        Student s = studentRepository.save(student);
//        ObjectNode response = new ObjectNode(JsonNodeFactory.instance);
//        response.put("id", s.getId());
//        response.put("status", "success");
//        return response;
//    }

}