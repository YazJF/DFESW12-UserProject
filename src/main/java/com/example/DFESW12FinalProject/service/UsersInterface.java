package com.example.DFESW12FinalProject.service;

import com.example.DFESW12FinalProject.domain.Users;

import java.util.List;
import java.util.Optional;

public interface UsersInterface<T> {

    Users create(Users u);

    List<Users> read();

    Users update(T id, Users u);

    Boolean delete(T id);


}
