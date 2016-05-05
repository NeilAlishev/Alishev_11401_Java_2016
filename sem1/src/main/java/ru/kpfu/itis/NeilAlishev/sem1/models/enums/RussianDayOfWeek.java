package ru.kpfu.itis.NeilAlishev.sem1.models.enums;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
public enum RussianDayOfWeek {
    MONDAY("Понедельник"), TUESDAY("Вторник"), WEDNESDAY("Среда"),
    THURSDAY("Четверг"), FRIDAY("Пятница"), SATURDAY("Суббота");

    private String translation;

    RussianDayOfWeek(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}
