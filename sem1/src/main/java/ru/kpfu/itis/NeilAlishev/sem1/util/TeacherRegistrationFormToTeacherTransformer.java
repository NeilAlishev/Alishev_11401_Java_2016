package ru.kpfu.itis.NeilAlishev.sem1.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.NeilAlishev.sem1.models.Teacher;
import ru.kpfu.itis.NeilAlishev.sem1.models.enums.Role;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Component
public class TeacherRegistrationFormToTeacherTransformer {
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static Teacher transform(TeacherRegistrationForm teacherRegistrationForm) {
        Teacher teacher = new Teacher();
        teacher.setFullName(teacherRegistrationForm.getFullName());
        teacher.setEmail(teacherRegistrationForm.getEmail());
        teacher.setQualification(teacherRegistrationForm.getQualification());
        teacher.setContacts(teacherRegistrationForm.getContacts());
        teacher.setPassword(encoder.encode(teacherRegistrationForm.getPassword()));
        teacher.setRole(Role.ROLE_TEACHER);
        return teacher;
    }
}
