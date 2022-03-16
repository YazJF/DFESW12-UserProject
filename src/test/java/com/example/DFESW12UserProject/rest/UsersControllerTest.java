package com.example.DFESW12UserProject.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
//@Sql(scripts = {"classpath:users","classpath:users-data.sql"}, executionPhase = Sql.ExecutionPhase,BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class UsersControllerTest {


    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper map;

    @Test
    void testCreate() throws Exception {


    }

    @Test
    void readAll() throws Exception {


    }
}
