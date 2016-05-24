package ru.kpfu.itis.NeilAlishev.sem1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.NeilAlishev.sem1.models.Group;
import ru.kpfu.itis.NeilAlishev.sem1.models.Teacher;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.GroupRepository;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.TeacherRepository;
import ru.kpfu.itis.NeilAlishev.sem1.service.TeacherService;

import java.util.List;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    GroupRepository groupRepository;


    @Override
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherByID(long id) {
        return teacherRepository.findOne(id);
    }

    @Override
    public void add(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void addGroup(Teacher teacher, Group group) {
        teacher = teacherRepository.findOne(teacher.getId());
        group = groupRepository.findOne(group.getId());
        teacher.getGroups().add(group);
    }

    @Override
    public List<Teacher> findAllByGroup(Group group) {
        return teacherRepository.findByGroups(group);
    }
}
