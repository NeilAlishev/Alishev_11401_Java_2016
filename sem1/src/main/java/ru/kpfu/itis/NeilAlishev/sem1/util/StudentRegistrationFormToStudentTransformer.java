package ru.kpfu.itis.NeilAlishev.sem1.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.NeilAlishev.sem1.models.Group;
import ru.kpfu.itis.NeilAlishev.sem1.models.Student;
import ru.kpfu.itis.NeilAlishev.sem1.models.enums.Role;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.GroupRepository;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Component
public class StudentRegistrationFormToStudentTransformer {
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static Student transform(StudentRegistrationForm studentRegistrationForm) {
        Student student = new Student();
        student.setFullName(studentRegistrationForm.getFullName());
        student.setEmail(studentRegistrationForm.getEmail());
        student.setPhoneNumber(studentRegistrationForm.getPhoneNumber());
        student.setInterests(studentRegistrationForm.getInterests());
        student.setPassword(encoder.encode(studentRegistrationForm.getPassword()));
        student.setRole(Role.ROLE_STUDENT);
        return student;
    }
}
