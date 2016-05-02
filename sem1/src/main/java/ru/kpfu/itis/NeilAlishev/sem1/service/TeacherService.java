package ru.kpfu.itis.NeilAlishev.sem1.service;

import ru.kpfu.itis.NeilAlishev.sem1.models.Teacher;

import java.util.List;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
public interface TeacherService {
    public List<Teacher> getTeachers();

    public Teacher getTeacherByID(long id);

    public void add(Teacher teacher);
}
