package ru.kpfu.itis.NeilAlishev.sem1.service;


import ru.kpfu.itis.NeilAlishev.sem1.models.Group;

/**
 * @author Nail Alishev
 */
public interface GroupService {
    void create(Group group);

    void delete(Group group);

    void update(Group group, String name);
}
