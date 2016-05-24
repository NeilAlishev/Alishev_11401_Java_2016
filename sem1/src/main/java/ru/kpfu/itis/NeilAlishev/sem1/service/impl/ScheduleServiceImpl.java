package ru.kpfu.itis.NeilAlishev.sem1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.NeilAlishev.sem1.models.Schedule;
import ru.kpfu.itis.NeilAlishev.sem1.repositories.ScheduleRepository;
import ru.kpfu.itis.NeilAlishev.sem1.service.ScheduleService;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public void createOrUpdate(Schedule schedule) {
        scheduleRepository.save(schedule);
    }
}
