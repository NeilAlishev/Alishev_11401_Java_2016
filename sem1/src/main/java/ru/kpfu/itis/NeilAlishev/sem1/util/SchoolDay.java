package ru.kpfu.itis.NeilAlishev.sem1.util;

import javax.persistence.Embeddable;
import java.time.DayOfWeek;
import java.util.Arrays;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Embeddable
public class SchoolDay implements Comparable<SchoolDay> {
    private DayOfWeek dayOfWeek;
    private String[] lessons;

    public SchoolDay() {

    }

    public SchoolDay(DayOfWeek dayOfWeek, String[] lessons) {
        this.dayOfWeek = dayOfWeek;
        this.lessons = lessons;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String[] getLessons() {
        return lessons;
    }

    public void setLessons(String[] lessons) {
        this.lessons = lessons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SchoolDay schoolDay = (SchoolDay) o;

        if (dayOfWeek != schoolDay.dayOfWeek) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(lessons, schoolDay.lessons);

    }

    @Override
    public int hashCode() {
        int result = dayOfWeek != null ? dayOfWeek.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(lessons);
        return result;
    }

    @Override
    public int compareTo(SchoolDay o) {
        if (this.dayOfWeek.getValue() > o.dayOfWeek.getValue()) {
            return 1;
        } else if (this.dayOfWeek.getValue() < o.dayOfWeek.getValue()) {
            return -1;
        }
        return 0;
    }
}
