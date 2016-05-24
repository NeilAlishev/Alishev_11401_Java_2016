package ru.kpfu.itis.NeilAlishev.sem1.util;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Neil Alishev
 * 11-401
 * sem1
 */
public class TeacherRegistrationForm {

    @NotEmpty(message = "Это поле не может быть пустым")
    private String fullName;

    @NotEmpty(message = "Это поле не может быть пустым")
    @Email(message = "Некорректный email")
    private String email;

    @NotEmpty(message = "Это поле не может быть пустым")
    private String qualification;

    private String contacts;

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
