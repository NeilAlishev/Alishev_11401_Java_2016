package ru.kpfu.itis.NeilAlishev.sem1.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Entity
@Table(name = "students")
public class Student extends User {

    private String phoneNumber;

    private String interests;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "student")
    private Set<Mark> marks;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }
}

