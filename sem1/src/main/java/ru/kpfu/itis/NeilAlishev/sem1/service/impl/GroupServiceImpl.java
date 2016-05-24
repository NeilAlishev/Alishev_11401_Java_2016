package ru.kpfu.itis.NeilAlishev.sem1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.NeilAlishev.sem1.models.Group;
import ru.kpfu.itis.NeilAlishev.sem1.models.Schedule;
import ru.kpfu.itis.NeilAlishev.sem1.models.Teacher;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.GroupRepository;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.ScheduleRepository;
import ru.kpfu.itis.NeilAlishev.sem1.service.GroupService;
import ru.kpfu.itis.NeilAlishev.sem1.util.SchoolDay;

import javax.servlet.http.HttpServletRequest;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;


    @Override
    public void createOrUpdate(Group group) {
        groupRepository.save(group);
    }

    @Override
    public void delete(Group group) {
        groupRepository.delete(group);
    }

    @Override
    public void update(Group group, String name) {
        Group newGroup = groupRepository.findOne(group.getId());
        newGroup.setName(name);
    }

    @Override
    public void addScheduleToGroup(Group currentGroup, HttpServletRequest request) {
        Schedule currentSchedule = setSchoolDays(request);
        currentSchedule = scheduleRepository.save(currentSchedule); // Сохраняем расписание
        Group group = groupRepository.findOne(currentGroup.getId()); // Мерджим
        group.setSchedule(currentSchedule);
    }

    @Override
    public List<Group> findAllByTeacher(Teacher teacher) {
        return groupRepository.findByTeachers_Id(teacher.getId());
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group findByName(String name) {
        return groupRepository.findOneByName(name);
    }


    private Schedule setSchoolDays(HttpServletRequest request) {
        Schedule schedule = new Schedule();
        for (int i = 0; i < 6; i++) {                                            // Days of the week
            List<String> lessons = new ArrayList<>();
            for (int j = 0; j < 10; j++) {                                     // Lessons
                String lesson = request.getParameter(i + "[" + j + "]");

                if (lesson == null || lesson.equals(""))
                    break;

                lessons.add(lesson);

            }
            schedule.getSchoolDays().add(new SchoolDay(DayOfWeek.of(i + 1), lessons.toArray(new String[lessons.size()])));
        }
        return schedule;
    }
}
