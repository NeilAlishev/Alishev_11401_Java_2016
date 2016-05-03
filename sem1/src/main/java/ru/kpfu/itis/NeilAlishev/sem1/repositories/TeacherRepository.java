package ru.kpfu.itis.NeilAlishev.sem1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.NeilAlishev.sem1.models.Group;
import ru.kpfu.itis.NeilAlishev.sem1.models.Teacher;

import java.util.List;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findOneByEmail(String email);

    List<Teacher> findByGroups(Group group);
}
