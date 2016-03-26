package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Nail Alishev
 *         11-401
 *         task 014
 */
@Controller
@RequestMapping("/getdate")
public class DateController {
    @RequestMapping(method = RequestMethod.GET)
    public String datePage() {
        return "date";
    }
}
