package ru.kpfu.itis.NeilAlishev.sem1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.NeilAlishev.sem1.models.Mark;
import ru.kpfu.itis.NeilAlishev.sem1.models.Student;
import ru.kpfu.itis.NeilAlishev.sem1.models.Teacher;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.MarkRepository;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.StudentRepository;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.TeacherRepository;
import ru.kpfu.itis.NeilAlishev.sem1.service.MarkService;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Service
@Transactional
public class MarkServiceImpl implements MarkService {

    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void addMark(Teacher currentTeacher, HttpServletRequest request) {
        currentTeacher = teacherRepository.findOne(currentTeacher.getId());
        Student currentStudent = studentRepository.findOne(Long.parseLong(request.getParameter("student")));
        Mark newMark = new Mark();
        newMark.setStudent(currentStudent);
        newMark.setTeacher(currentTeacher);
        newMark.setSubject(request.getParameter("subject"));
        newMark.setScore(Integer.parseInt(request.getParameter("score")));

        String[] ddMmYy = request.getParameter("date").split("-");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(ddMmYy[0]));
        cal.set(Calendar.MONTH, Integer.parseInt(ddMmYy[1]));
        cal.set(Calendar.YEAR, Integer.parseInt(ddMmYy[2]));
        Date dateRepresentation = cal.getTime();
        newMark.setCreatedAt(dateRepresentation);
        markRepository.save(newMark);
    }
}
