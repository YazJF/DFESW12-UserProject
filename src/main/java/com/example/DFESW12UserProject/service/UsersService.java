package com.example.DFESW12UserProject.service;


import com.example.DFESW12UserProject.domain.Users;
import com.example.DFESW12UserProject.exceptions.UserNotFoundException;
import com.example.DFESW12UserProject.repo.UsersRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements UsersInterface<Long>{

   private UsersRepo repo;

   public UsersService(UsersRepo repo){
       super();
       this.repo = repo;
   }

    @Override
    public Users create(Users u) {
        return this.repo.save(u);
    }

    @Override
    public List<Users> read() {
        return this.repo.findAll();
    }

    @Override
    public Users update(Long id, Users u) {
        Optional<Users> userOptional = this.repo.findById(id);
        Users current = userOptional.get();
        current.setFirstname(u.getFirstname());
        current.setSurname(u.getSurname());
        current.setEmail(u.getEmail());
        current.setUsername(u.getUsername());
        current.setPassword(u.getPassword());
        current.setAge(u.getAge());
        current.setMailingList(u.getMailingList());

        return this.repo.save(current);
    }

    @Override
    public Boolean delete(Long id) {
        this.repo.deleteById(id);
        boolean exists = this.repo.existsById(id);
        return !exists;
    }


    public Users findById(Long id) {
        Optional<Users> foundUser = this.repo.findById(id);
        return foundUser.orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<Users> findByAge(Long age){
        return this.repo.findByAge(age);
    }

    @Override
    public List<Users> findByMailingList(Boolean mailList) {
        return this.repo.findByMailingList(mailList);
    }
}
