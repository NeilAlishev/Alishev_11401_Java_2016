package ru.kpfu.itis.NeilAlishev.sem1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.NeilAlishev.sem1.models.Student;

/**
 * Created by neil on 11.04.16.
 */
@Repository
public interface StudentsRepository extends JpaRepository<Student, Integer> {
}
