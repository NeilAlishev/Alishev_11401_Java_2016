package ru.kpfu.itis.NeilAlishev.sem1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.NeilAlishev.sem1.models.Homework;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.HomeworkRepository;
import ru.kpfu.itis.NeilAlishev.sem1.service.HomeworkService;
import ru.kpfu.itis.NeilAlishev.sem1.util.HomeworkBuilder;

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

    @Override
    public boolean saveHomework(HttpServletRequest request) {
        Homework currentHomework = HomeworkBuilder.buildHomework(request);
        return false;
    }
}
