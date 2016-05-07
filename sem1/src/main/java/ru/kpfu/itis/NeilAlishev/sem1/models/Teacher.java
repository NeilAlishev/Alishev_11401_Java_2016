package ru.kpfu.itis.NeilAlishev.sem1.models;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Entity
@Table(name = "teachers")
public class Teacher extends User {

    private String qualification;

    private String contacts;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "teachers_groups", joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<Group> groups;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Mark> marks;

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }
}

