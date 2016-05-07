package ru.kpfu.itis.NeilAlishev.sem1.service;

import ru.kpfu.itis.NeilAlishev.sem1.models.Teacher;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
public interface MarkService {
    void addMark(Teacher currentTeacher, HttpServletRequest request);
}
