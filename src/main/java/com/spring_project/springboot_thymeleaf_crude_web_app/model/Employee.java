package com.spring_project.springboot_thymeleaf_crude_web_app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="employees")
public class Employee {

    @Id
    @GeneratedValue
    private long id;

    @Column(name="First_name")
    private String firstName;

    @Column(name="Last_name")
    private String lastName;

    @Column(name="E_mail")
    private String email;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee(String firstName, String lastName, long id, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.email = email;
    }

    public Employee() {
    }
}
