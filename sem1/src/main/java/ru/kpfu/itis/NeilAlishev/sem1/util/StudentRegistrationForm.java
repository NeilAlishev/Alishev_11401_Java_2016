package ru.kpfu.itis.NeilAlishev.sem1.util;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import ru.kpfu.itis.NeilAlishev.sem1.models.Group;

import javax.validation.constraints.Size;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
public class StudentRegistrationForm {

    @NotEmpty(message = "Это поле не может быть пустым")
    private String fullName;

    @NotEmpty(message = "Это поле не может быть пустым")
    @Email(message = "Некорректный email")
    private String email;

    @NotEmpty(message = "Это поле не может быть пустым")
    private String phoneNumber;

    private String interests;

    private String group;

    @Size(min = 7, max = 20, message = "Неверная длина пароля")
    private String password;

    @Size(min = 7, max = 20, message = "Неверная длина пароля")
    private String passwordConfirmation;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

}
