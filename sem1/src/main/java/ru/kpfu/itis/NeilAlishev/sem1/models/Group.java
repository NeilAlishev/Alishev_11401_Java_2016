package ru.kpfu.itis.NeilAlishev.sem1.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Entity
@Table(name = "groups")
@SequenceGenerator(name = "groups_gen", sequenceName = "groups_seq", allocationSize = 1)
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groups_gen")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "groups")
    private List<Teacher> teachers;

    @OneToOne(fetch = FetchType.EAGER)
    private Schedule schedule;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        return name != null ? name.equals(group.name) : group.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
