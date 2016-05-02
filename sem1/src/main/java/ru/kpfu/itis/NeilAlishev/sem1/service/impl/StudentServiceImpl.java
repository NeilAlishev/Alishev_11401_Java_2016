package ru.kpfu.itis.NeilAlishev.sem1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.NeilAlishev.sem1.models.Student;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.StudentRepository;
import ru.kpfu.itis.NeilAlishev.sem1.service.StudentService;

import java.util.List;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentsRepository;

    @Override
    public List<Student> getAll() {
        return studentsRepository.findAll();
    }

    @Override
    public Student getOne(Long id) {
        return studentsRepository.findOne(id);
    }

    @Override
    public Student getCurrent() {
        return null;
    }


    @Override
    public void add(Student student) {
        studentsRepository.save(student);
    }

    @Override
    public void update(Student student) {
//        User newUser = userRepository.findOne(user.getId());
//        newUser.setEmail(user.getEmail());
//        newUser.setName(user.getName());
//        newUser.setSurname(user.getSurname());
    }
}
