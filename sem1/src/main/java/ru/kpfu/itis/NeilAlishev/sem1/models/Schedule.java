package ru.kpfu.itis.NeilAlishev.sem1.models;

import ru.kpfu.itis.NeilAlishev.sem1.util.SchoolDay;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Entity
@SequenceGenerator(name = "schedules_gen", sequenceName = "schedules_seq", allocationSize = 1)
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedules_gen")
    private Long id;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<SchoolDay> schoolDays = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<SchoolDay> getSchoolDays() {
        return schoolDays;
    }

    public void setSchoolDays(Set<SchoolDay> schoolDays) {
        this.schoolDays = schoolDays;
    }
}
