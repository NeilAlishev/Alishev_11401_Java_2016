package ru.kpfu.itis.NeilAlishev.sem1.util;

import java.util.Date;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
public class SimpleMark {
    private String subject;
    private Integer score;
    private Date date;

    public SimpleMark(String subject, Integer score, Date date) {
        this.subject = subject;
        this.score = score;
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
