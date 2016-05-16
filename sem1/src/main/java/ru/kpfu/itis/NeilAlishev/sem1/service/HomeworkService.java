package ru.kpfu.itis.NeilAlishev.sem1.service;

import ru.kpfu.itis.NeilAlishev.sem1.models.Homework;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
public interface HomeworkService {
    public boolean saveHomework(HttpServletRequest request, Long teacherId);
}
