package ru.kpfu.itis.NeilAlishev.sem1.util;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.NeilAlishev.sem1.models.Group;
import ru.kpfu.itis.NeilAlishev.sem1.models.Homework;
import ru.kpfu.itis.NeilAlishev.sem1.models.Teacher;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Component
public class HomeworkBuilder {

    public static Homework buildHomework(HttpServletRequest request, Teacher currentTeacher, Group currentGroup) {
        Homework currentHomework = new Homework();
        currentHomework.setGroup(currentGroup);
        currentHomework.setTeacher(currentTeacher);
        currentHomework.setSubject(request.getParameter("subject"));
        currentHomework.setMessage(request.getParameter("message"));

        if (request.getParameter("deadline").equals("")) {
            return currentHomework;
        }

        // setting deadline
        String[] ddMmYy = request.getParameter("deadline").split("-");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(ddMmYy[0]));
        cal.set(Calendar.MONTH, Integer.parseInt(ddMmYy[1]));
        cal.set(Calendar.YEAR, Integer.parseInt(ddMmYy[2]));
        Date dateRepresentation = cal.getTime();
        currentHomework.setDeadline(dateRepresentation);

        return currentHomework;
    }
}
