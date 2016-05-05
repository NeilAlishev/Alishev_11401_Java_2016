package ru.kpfu.itis.NeilAlishev.sem1.service;

import ru.kpfu.itis.NeilAlishev.sem1.models.Schedule;
import ru.kpfu.itis.NeilAlishev.sem1.models.Student;

import java.util.List;

/**
 * @author Nail Alishev
 */
public interface StudentService {
    List<Student> getAll();

    Student getCurrent();

    Student getOne(Long id);

    void add(Student student);

    void update(Student student);

    Schedule getSchedule(Student student);
}
