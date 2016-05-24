package ru.kpfu.itis.NeilAlishev.sem1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.NeilAlishev.sem1.models.Admin;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findOneByEmail(String email);
}
