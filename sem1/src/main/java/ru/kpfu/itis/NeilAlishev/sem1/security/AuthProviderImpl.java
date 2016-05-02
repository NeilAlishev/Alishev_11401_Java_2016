package ru.kpfu.itis.NeilAlishev.sem1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.NeilAlishev.sem1.models.Admin;
import ru.kpfu.itis.NeilAlishev.sem1.models.Student;
import ru.kpfu.itis.NeilAlishev.sem1.models.Teacher;
import ru.kpfu.itis.NeilAlishev.sem1.models.User;
import ru.kpfu.itis.NeilAlishev.sem1.models.enums.Role;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.AdminRepository;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.StudentRepository;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.TeacherRepository;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Component
public class AuthProviderImpl implements AuthenticationProvider {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    AdminRepository adminRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        User user;
        Student student = studentRepository.findOneByEmail(email);
        Teacher teacher = teacherRepository.findOneByEmail(email);
        Admin admin = adminRepository.findOneByEmail(email);

        if (student == null && teacher == null && admin == null)
            throw new UsernameNotFoundException("User not found");


        if (student != null) {
            user = student;
        } else if (teacher != null) {
            user = teacher;
        } else {
            user = admin;
        }

        String password = authentication.getCredentials().toString();

        if (!encoder.matches(password, user.getPassword()))
            throw new BadCredentialsException("Invalid password");

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        if (user.getRole().equals(Role.ROLE_STUDENT)) {
            return new UsernamePasswordAuthenticationToken(student, null, authorities);
        } else if (user.getRole().equals(Role.ROLE_TEACHER)) {
            return new UsernamePasswordAuthenticationToken(teacher, null, authorities);
        } else {
            return new UsernamePasswordAuthenticationToken(admin, null, authorities);
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}

