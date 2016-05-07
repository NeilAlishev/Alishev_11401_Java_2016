package ru.kpfu.itis.NeilAlishev.sem1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.NeilAlishev.sem1.models.Mark;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.MarkRepository;

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
    MarkRepository markRepository;

    @RequestMapping(value = "/downloadPDF", method = RequestMethod.GET)
    public ModelAndView downloadExcel() {
        List<Mark> listMarks = new ArrayList<Mark>();
        markRepository.findAll().forEach(
                listMarks::add
        );
        // return a view which will be resolved by an excel view resolver
        return new ModelAndView("pdfView", "listMarks", listMarks);
    }
}
