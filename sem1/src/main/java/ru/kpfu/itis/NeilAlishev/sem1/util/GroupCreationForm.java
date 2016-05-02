package ru.kpfu.itis.NeilAlishev.sem1.util;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
public class GroupCreationForm {

    @NotEmpty(message = "Это поле не должно быть пустым")
    @Pattern(regexp = "[\\p{IsCyrillic}]{1,50}_\\d{1,4}_\\d{1,2}_[\\p{IsCyrillic}]", message = "Не соответсвует формату")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
