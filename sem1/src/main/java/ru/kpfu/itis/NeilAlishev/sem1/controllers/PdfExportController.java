package ru.kpfu.itis.NeilAlishev.sem1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.NeilAlishev.sem1.models.Mark;
import ru.kpfu.itis.NeilAlishev.sem1.models.Student;
import ru.kpfu.itis.NeilAlishev.sem1.models.User;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.MarkRepository;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.StudentRepository;
import ru.kpfu.itis.NeilAlishev.sem1.service.StudentService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Controller
public class PdfExportController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/downloadPDF", method = RequestMethod.GET)
    public ModelAndView downloadExcel() {
        List<Mark> listMarks = new ArrayList<Mark>();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Student currentStudent = studentService.getOne(user.getId());

        currentStudent.getMarks().forEach(
                listMarks::add
        );

        // return a view which will be resolved by an excel view resolver
        return new ModelAndView("pdfView", "listMarks", listMarks);
    }
}
