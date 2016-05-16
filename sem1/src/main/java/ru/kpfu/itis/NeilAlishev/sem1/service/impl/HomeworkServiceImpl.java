package ru.kpfu.itis.NeilAlishev.sem1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.NeilAlishev.sem1.models.Group;
import ru.kpfu.itis.NeilAlishev.sem1.models.Homework;
import ru.kpfu.itis.NeilAlishev.sem1.models.Teacher;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.GroupRepository;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.HomeworkRepository;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.TeacherRepository;
import ru.kpfu.itis.NeilAlishev.sem1.service.HomeworkService;
import ru.kpfu.itis.NeilAlishev.sem1.util.HomeworkBuilder;
import ru.kpfu.itis.NeilAlishev.sem1.util.HomeworkValidator;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Service
@Transactional
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    HomeworkRepository homeworkRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    GroupRepository groupRepository;

    @Override
    public boolean saveHomework(HttpServletRequest request, Long teacherId) {
        Teacher currentTeacher = teacherRepository.findOne(teacherId);
        Group currentGroup = groupRepository.findOne(Long.parseLong(request.getParameter("id")));
        Homework currentHomework = HomeworkBuilder.buildHomework(request, currentTeacher, currentGroup);
        if (HomeworkValidator.valid(currentHomework)) {
            homeworkRepository.save(currentHomework);
            return true;
        } else {
            return false;
        }
    }
}
