package ru.kpfu.itis.NeilAlishev.sem1.models;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Entity
@Table(name = "marks")
@SequenceGenerator(name = "marks_gen", sequenceName = "marks_seq", allocationSize = 1)
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "marks_gen")
    private Long id;

    private String subject;

    private Integer score;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Temporal(value = TemporalType.DATE)
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
