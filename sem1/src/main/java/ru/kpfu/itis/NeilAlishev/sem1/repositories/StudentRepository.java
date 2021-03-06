package ru.kpfu.itis.NeilAlishev.sem1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.NeilAlishev.sem1.models.Student;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findOneByEmail(String email);

    Student findOneByPhoneNumber(String phoneNumber);
}
