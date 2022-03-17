package com.example.DFESW12UserProject.rest;


import com.example.DFESW12UserProject.domain.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:users-schema.sql","classpath:users-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class UsersControllerTest {


    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper map;

    @Test
    void testCreate() throws Exception {
        //--request
        //type, url, body??
        //BODY - json - object
        Users create =  new Users("john","finlayson","john@john.com","yazjf","pass",29,false);

        // convert into JSON
        String createJSON = this.map.writeValueAsString(create);

        //build up mock request
        RequestBuilder mockRequest = post("/create").contentType(MediaType.APPLICATION_JSON).content(createJSON);

        //--response
        // body(JSON with id) + status
        Users saved = new Users(2L,"john","finlayson","john@john.com","yazjf","pass",29,false);
        //convert into JSON

        String savedJSON = this.map.writeValueAsString(saved);

        //--test response is correct
        //status = 201 CREATED
        ResultMatcher matchStatus = status().isCreated();
        //TEST RESPONSE BODY
        ResultMatcher matchBody = content().json(savedJSON);

        //perform test
        this.mock.perform(mockRequest).andExpectAll(matchStatus).andExpect(matchBody);

    }

    @Test
    void readAll() throws Exception {


    }
}
