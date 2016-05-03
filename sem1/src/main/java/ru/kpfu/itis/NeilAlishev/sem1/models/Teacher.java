package ru.kpfu.itis.NeilAlishev.sem1.models;

import javax.persistence.*;
import java.util.List;

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
    private List<Group> groups;

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

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}

