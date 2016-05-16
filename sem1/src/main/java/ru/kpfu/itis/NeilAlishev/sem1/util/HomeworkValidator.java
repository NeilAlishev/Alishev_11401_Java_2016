package ru.kpfu.itis.NeilAlishev.sem1.util;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.NeilAlishev.sem1.models.Homework;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Component
public class HomeworkValidator {

    public static boolean valid(Homework homework) {
        return !(homework.getSubject().equals("") ||
                homework.getMessage().equals("") ||
                homework.getDeadline() == null);
    }
}
