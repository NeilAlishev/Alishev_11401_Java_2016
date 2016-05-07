package ru.kpfu.itis.NeilAlishev.sem1.service;

import ru.kpfu.itis.NeilAlishev.sem1.models.Group;
import ru.kpfu.itis.NeilAlishev.sem1.models.Schedule;
import ru.kpfu.itis.NeilAlishev.sem1.models.Student;

import java.util.List;

/**
 * @author Nail Alishev
 */
public interface StudentService {
    List<Student> getAll();

    Student getOne(Long id);

    void addStudent(Student student, Group group);

    void update(Student student);

    Schedule getSchedule(Student student);
}
