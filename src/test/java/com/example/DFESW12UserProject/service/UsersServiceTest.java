package com.example.DFESW12UserProject.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.DFESW12UserProject.domain.Users;
import com.example.DFESW12UserProject.repo.UsersRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

//import com.example.DFESW12UserProject.domain.Users;
//import com.example.DFESW12UserProject.repo.UsersRepo;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
public class UsersServiceTest {

    private Users input;
    private Users returned;


    @Autowired
    private UsersService serv;

    @MockBean
    private UsersRepo rep;

    @BeforeEach
    void setUp() {
        input = new Users("john","finlayson","john@john.com","yazjf","pass",29,false);
        returned = new Users(1L,"john","finlayson","john@john.com","yazjf","pass",29,false);
    }

    @Test
    void testCreate() {
        Mockito.when(this.rep.save(input)).thenReturn(returned);

//        System.out.println(returned); //additional measure to check accuracy
//        System.out.println(this.serv.create(input));

        assertThat(this.serv.create(input)).isEqualTo(returned);

        Mockito.verify(this.rep, Mockito.times(1)).save(input);

    }

    @Test
    void testRead() {
        List<Users> userList = List.of(new Users("john","finlayson","john@john.com","yazjf","pass",29,false));

        Mockito.when(this.rep.findAll()).thenReturn(userList);

        assertThat(this.serv.read()).isEqualTo(userList);

        Mockito.verify(this.rep, Mockito.times(1)).findAll();


    }

    @Test
    void testFindById() {
        Long searchId = 1L;

        Mockito.when(this.rep.findById(searchId)).thenReturn(Optional.of(returned));

//        System.out.println(returned); //additional measure to check accuracy
//        System.out.println(this.serv.findById(searchId));

        assertThat(this.serv.findById(searchId)).isEqualTo(returned);

        Mockito.verify(this.rep, Mockito.times(1)).findById(searchId);

    }

    @Test
    void testDelete() {
        Long id = 1L;

        Mockito.when(this.rep.existsById(id)).thenReturn(false);

        assertThat(this.serv.delete(id)).isTrue();

        Mockito.verify(this.rep, Mockito.times(1)).existsById(id);
    }

    @Test
    void testUpdate() {
        Long id = 1L;

        Users toUpdate = new Users("john","finlayson","john@john.com","yazjf","pass",29,false);

        Optional<Users> optUser = Optional.of(returned);

        Users updated = new Users(id, toUpdate.getFirstname(), toUpdate.getSurname(), toUpdate.getEmail(), toUpdate.getUsername(), toUpdate.getPassword(), toUpdate.getAge(), toUpdate.getMailingList());

        Mockito.when(this.rep.findById(id)).thenReturn(optUser);
        Mockito.when(this.rep.save(updated)).thenReturn(updated);

//        System.out.println(updated); //additional measure to check accuracy
//        System.out.println(this.serv.update(id, toUpdate));

        assertThat(this.serv.update(id, toUpdate)).isEqualTo(updated);

        Mockito.verify(this.rep, Mockito.times(1)).findById(id);
        Mockito.verify(this.rep, Mockito.times(1)).save(updated);
    }



}
