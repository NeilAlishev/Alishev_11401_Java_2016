package ru.kpfu.itis.NeilAlishev.sem1.service;


import ru.kpfu.itis.NeilAlishev.sem1.models.Group;
import ru.kpfu.itis.NeilAlishev.sem1.models.Schedule;
import ru.kpfu.itis.NeilAlishev.sem1.models.Teacher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
public interface GroupService {
    void createOrUpdate(Group group);

    void delete(Group group);

    void update(Group group, String name);

    void addScheduleToGroup(Group currentGroup, HttpServletRequest request);

    List<Group> findAllByTeacher(Teacher teacher);

    List<Group> findAll();

    Group findByName(String name);
}
