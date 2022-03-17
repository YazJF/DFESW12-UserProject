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

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
        Users create =  new Users("john","finlayson","john@john.com","yazjf","pass",29L,false);

        // convert into JSON
        String createJSON = this.map.writeValueAsString(create);

        //build up mock request
        RequestBuilder mockRequest = post("/create").contentType(MediaType.APPLICATION_JSON).content(createJSON);

        //--response
        // body(JSON with id) + status
        Users saved = new Users(2L,"john","finlayson","john@john.com","yazjf","pass",29L,false);
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


        String findAll =  this.map.writeValueAsString(List.of(new Users(1L,"john","finlayson","john@john.com","yazjf","pass",29L,false)));


        RequestBuilder mockRequest = get("/readAll");


        ResultMatcher matchStatus = status().isFound();
        ResultMatcher matchBody = content().json(findAll);

        this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

    }

    @Test
    void deleteByID() throws Exception {
        Long id = 1L;

        RequestBuilder mockRequest = delete("/deleteById/" + id);


        ResultMatcher matchStatus = status().isGone();
        ResultMatcher matchBody = content().string("true");

        this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);



    }

    @Test
    void findByID() throws Exception{
        Long id = 1L;

        Users testUser =  new Users(1L,"john","finlayson","john@john.com","yazjf","pass",29L,false);

        String createJSON = this.map.writeValueAsString(testUser);

        RequestBuilder mockRequest = get("/findById/" + id);


        ResultMatcher matchStatus = status().isFound();
        ResultMatcher matchBody = content().json(createJSON);

        this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

    }

    @Test
    void update() throws Exception{
        Long id = 1L;

        Users testUser =  new Users(1L,"jhn","fnlayson","john@john.com","yazjf","pass",29L,false);

        String createJSON = this.map.writeValueAsString(testUser);

        RequestBuilder mockRequest = put("/update/" + id).contentType(MediaType.APPLICATION_JSON)
                .content(createJSON);


        ResultMatcher matchStatus = status().isAccepted();
        ResultMatcher matchBody = content().json(createJSON);

        this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);


    }

    @Test
    void findByAge() throws Exception{
        Long searchAge = 29L;

        List<Users> testUser = List.of(new Users(1L,"john","finlayson","john@john.com","yazjf","pass",29L,false));

        String createJSON = this.map.writeValueAsString(testUser);

        RequestBuilder mockRequest = get("/getByAge/" + searchAge);

        ResultMatcher matchStatus = status().isFound();
        ResultMatcher matchBody = content().json(createJSON);

        this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);


    }

    @Test
    void findByMailingList() throws Exception{
        Boolean onList = false;

        List<Users> testUser = List.of(new Users(1L,"john","finlayson","john@john.com","yazjf","pass",29L,false));

        String createJson = this.map.writeValueAsString(testUser);

        RequestBuilder mockRequest = get("/findByMailingList/" + onList);

        ResultMatcher matchStatus = status().isFound();
        ResultMatcher matchBody = content().json(createJson);

        this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);




    }

}
