package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nail Alishev
 *         11-401
 *         task 015
 */
@Controller
@RequestMapping("/process")
public class ProcessController {
    @RequestMapping(method = RequestMethod.GET)
    public String getProcess() {
        return "process";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postProcess(ModelMap m, HttpServletRequest request) {
        Pattern pattern;
        Matcher matcher;
        int count = 0;
        String text = request.getParameter("text");
        if (request.getParameter("operation").equals("symbols")) {
            pattern = Pattern.compile("[^\\s]");
            matcher = pattern.matcher(text);
            while (matcher.find()) {
                count++;
            }
            m.put("result", count);
        } else if (request.getParameter("operation").equals("words")) {
            pattern = Pattern.compile("[a-zA-Z]+");
            matcher = pattern.matcher(text);
            while (matcher.find()) {
                count++;
            }
            m.put("result", count);
        } else if (request.getParameter("operation").equals("sentences")) {
            pattern = Pattern.compile("[A-Z].+?((\\.)|(!)|(\\?))");
            matcher = pattern.matcher(text);
            while (matcher.find()) {
                count++;
            }
            m.put("result", count);
        } else {
            pattern = Pattern.compile("[ ]{2,}");
            matcher = pattern.matcher(text);
            while (matcher.find()) {
                count++;
            }
            m.put("result", count);
        }
        return "result";
    }
}
