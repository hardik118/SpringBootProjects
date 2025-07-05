package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.http.MediaType;

import javax.print.attribute.standard.Media;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    /*
    objective: testing userManagemenet Api;
    setup:
    configured :
    1->Mockmcv to mock req, res;
    2->objectmapper to mock coming json based req body
    3->intiliazed  userRepo to mock db interactions








     */
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;
    private User user1;
    private User user2;
    private long initialCount;

    @BeforeEach
    void setup(){
        userRepository.deleteAll();

        objectMapper.registerModule(new JavaTimeModule());

        User initialUser1= new User("Jon mohan", "jonmohan@gmail.com");
        User initialUser2= new User("Jagdish caca", "jagdishchacha@gmail.com");

        List<User> savedUser= userRepository.saveAll(Arrays.asList(initialUser1, initialUser2));

        this.user1= savedUser.get(0);
        this.user2= savedUser.get(1);


        List<User> manyUser = IntStream.rangeClosed(1, 25).mapToObj(i -> new User("user" + i, "user" + i + "@gmail.com"))
                .collect(Collectors.toList());

        userRepository.saveAll(manyUser);

        initialCount= userRepository.count();

    }

    //Arrange-Act-Assert

    @Test
    void testgetUserByIdFound() throws Exception{
        mockMvc.perform(get("/v1/api/users/{id}", user1.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(user1.getId().intValue())))
                .andExpect(jsonPath("$.name", is(user1.getName())))
                .andExpect(jsonPath("$.email", is(user1.getEmail())));
    }

    @Test
    void testUserisCreated() throws Exception {
        User mockUser1= new User("hardik yadav", "hy@gmail.com");
        User mockUser2= new User("faix ahem", "ily@gmail.com");

        List<User> userToCreate= Arrays.asList(mockUser1, mockUser2);



        mockMvc.perform(post("/v1/api/users/mockinput")
                        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(userToCreate)))
        .andExpect(status().isCreated())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", notNullValue()))
                .andExpect(jsonPath("$[0].name", is("hardik yadav")))
                .andExpect(jsonPath("$[0].email", is("hy@gmail.com")))
                .andExpect(jsonPath("$[1].id", notNullValue()))
                .andExpect(jsonPath("$[1].name", is("faix ahem")))
                .andExpect(jsonPath("$[1].email", is("ily@gmail.com")));


    }

    /*
    objective: create two tests for delete method over users
    test1: delete user , case : id is  found
    flow: we pass id  in url ,
    expecting user to be found and in,
     return getting noContent as expected from the test
    at last asserting to falsify the user is not there as its deleted
    method used: isnoContent to check for result of objective ,  and assertFalse for assertion

    test1: delete user , case : id is not  found
    flow: we pass id  in url ,
    expecting user to be not  found and in,
     return getting  isnotFound expected from the test
    method used: isnotFound to check for result of objective .

     */
    @Test
    void testCaseUserDoesnotIncludeIdInDeleteByIdRequest() throws Exception{
        mockMvc.perform(delete("/v1/api/users"))
                .andExpect(status().isMethodNotAllowed());

    }
    @Test
    void testDeleteUserByIdFound() throws Exception{
        mockMvc.perform(delete("/v1/api/users/{id}",user1.getId())).andExpect(status().isNoContent());
        assertFalse(userRepository.existsById(user1.getId()));


    }
    @Test
    void testUserIsNotFound() throws Exception{
        mockMvc.perform(delete("/v1/api/users/205" )).andExpect(status().isNotFound());

    }

   /* @Test
    void testgetUsers() throws Exception{
        mockMvc.perform(get("/v1/api/users").contentType(MediaType.APPLICATION_JSON)))
    }*/





}
