package ru.kpfu.itis.NeilAlishev.sem1.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.AdminRepository;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.StudentRepository;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.TeacherRepository;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Component
public class StudentValidator implements Validator {
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
        StudentRegistrationForm studentForm = (StudentRegistrationForm) o;
        if (studentRepository.findOneByEmail(studentForm.getEmail()) != null ||
                teacherRepository.findOneByEmail(studentForm.getEmail()) != null ||
                adminRepository.findOneByEmail(studentForm.getEmail()) != null) {
            errors.rejectValue("email", "", "Этот email уже используется");
        }
        if (studentRepository.findOneByPhoneNumber(studentForm.getPhoneNumber()) != null) {
            errors.rejectValue("phoneNumber", "", "Этот телефонный номер уже используется");
        }
        if (!studentForm.getPassword().equals(studentForm.getPasswordConfirmation())) {
            errors.rejectValue("passwordConfirmation", "", "Пароли не совпадают");
        }
    }
}
