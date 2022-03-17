package com.example.DFESW12UserProject.rest;


import com.example.DFESW12UserProject.domain.Users;
import com.example.DFESW12UserProject.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    private UsersService service;

    public UsersController(UsersService service) {
        super();
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Users> createUser(@RequestBody Users u){
        return new ResponseEntity<Users>(this.service.create(u), HttpStatus.CREATED);
    }

    @GetMapping("readAll")
    public ResponseEntity<Users> readUsers() {
        return new ResponseEntity(this.service.read(), HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
        return new ResponseEntity(this.service.delete(id), HttpStatus.GONE);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        return new ResponseEntity(this.service.findById(id), HttpStatus.FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Users updated) {
        return new ResponseEntity(this.service.update(id, updated), HttpStatus.ACCEPTED);
    }



}
