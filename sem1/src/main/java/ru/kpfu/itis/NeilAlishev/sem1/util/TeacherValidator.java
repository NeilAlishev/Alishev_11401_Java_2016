package ru.kpfu.itis.NeilAlishev.sem1.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.AdminRepository;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.StudentRepository;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.TeacherRepository;

/**
 * Neil Alishev
 * 11-401
 * sem1
 */
@Component
public class TeacherValidator implements Validator {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return StudentRegistrationForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        TeacherRegistrationForm teacherForm = (TeacherRegistrationForm) o;
        if (studentRepository.findOneByEmail(teacherForm.getEmail()) != null ||
                teacherRepository.findOneByEmail(teacherForm.getEmail()) != null ||
                adminRepository.findOneByEmail(teacherForm.getEmail()) != null) {
            errors.rejectValue("email", "", "Этот email уже используется");
        }
        if (!teacherForm.getPassword().equals(teacherForm.getPasswordConfirmation())) {
            errors.rejectValue("PasswordConfirmation", "", "Пароли не совпадают");
        }
    }
}
