package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Nail Alishev
 *         11-401
 *         task 014
 */
@Controller
@RequestMapping("/mult/*/*")
public class MultController {
    @RequestMapping(method = RequestMethod.GET)
    public String multNumbers(ModelMap m, HttpServletRequest request) {
        String[] numbers = request.getServletPath().split("/");
        Integer answer = Integer.parseInt(numbers[2]) * Integer.parseInt(numbers[3]);
        m.put("answer", answer);
        return "arithmetic";
    }
}
