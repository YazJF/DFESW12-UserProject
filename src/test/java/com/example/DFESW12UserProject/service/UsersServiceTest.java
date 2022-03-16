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

import com.example.DFESW12UserProject.domain.Users;
import com.example.DFESW12UserProject.repo.UsersRepo;

import java.util.List;

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



}
