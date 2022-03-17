package com.example.DFESW12UserProject.service;

import com.example.DFESW12UserProject.domain.Users;

import java.util.List;

public interface UsersInterface<T> {

    Users create(Users u);

    List<Users> read();

    Users update(T id, Users u);

    Boolean delete(T id);

    List<Users> findByAge(T age);

    List<Users> findByMailingList(Boolean mailList);


}
