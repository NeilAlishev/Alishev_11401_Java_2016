package ru.kpfu.itis.NeilAlishev.sem1.service;

import ru.kpfu.itis.NeilAlishev.sem1.models.Group;
import ru.kpfu.itis.NeilAlishev.sem1.models.Teacher;

import java.util.List;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
public interface TeacherService {
    List<Teacher> getTeachers();

    Teacher getTeacherByID(long id);

    void add(Teacher teacher);

    List<Teacher> findAllByGroup(Group group);
}
