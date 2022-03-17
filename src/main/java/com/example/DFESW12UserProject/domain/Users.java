package com.example.DFESW12UserProject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String surname;
    private String email;
    private String username;
    private String password;
    private Long age;
    private Boolean mailingList;


    public Users(String firstname, String surname, String email, String username, String password, Long age, Boolean mailingList) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.age = age;
        this.mailingList = mailingList;
    }

}