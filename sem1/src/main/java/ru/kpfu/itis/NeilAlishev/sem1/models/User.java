package ru.kpfu.itis.NeilAlishev.sem1.models;

import ru.kpfu.itis.NeilAlishev.sem1.models.enums.Role;

import javax.persistence.*;

/**
 * @author Nail Alishev
 *         11-401
 *         sem1
 */
@Entity
@SequenceGenerator(name = "users_gen", sequenceName = "users_seq", allocationSize = 1)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_gen")
    private Long id;

    private String fullName;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
