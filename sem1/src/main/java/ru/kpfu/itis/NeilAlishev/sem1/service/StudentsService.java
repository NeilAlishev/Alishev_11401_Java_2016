package ru.kpfu.itis.NeilAlishev.sem1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.NeilAlishev.sem1.models.Student;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.StudentsRepository;

import java.util.List;

/**
 * Created by neil on 11.04.16.
 */
@Service
public class StudentsService {
    @Autowired
    StudentsRepository studentsRepository;

    public List<Student> getStudents() {
        return studentsRepository.findAll();
    }

    public Student getStudentByID(int id) {
        return studentsRepository.findOne(id);
    }

}
