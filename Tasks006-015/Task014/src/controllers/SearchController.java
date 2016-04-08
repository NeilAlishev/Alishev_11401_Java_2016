package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Nail Alishev
 *         11-401
 *         task 014
 */
@Controller
@RequestMapping("/*/search")
public class SearchController {
    @RequestMapping(method = RequestMethod.GET)
    public String search(HttpServletRequest request) {
        String site = request.getServletPath().split("/")[1];
        return site + "SearchPage";
    }
}
