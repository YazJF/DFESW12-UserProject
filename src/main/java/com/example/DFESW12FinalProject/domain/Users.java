package com.example.DFESW12FinalProject.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String surname;
    private String email;
    private String username;
    private String password;
    private int age;
    private Boolean mailingList;


    public Users(Long id, String firstname, String surname, String email, String username, String password, int age, Boolean mailingList) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.age = age;
        this.mailingList = mailingList;
    }

    public Users(String firstname, String surname, String email, String username, String password, int age, Boolean mailingList) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.age = age;
        this.mailingList = mailingList;
    }

}