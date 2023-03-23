package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import lombok.Builder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@Builder
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IUserService userService;
    @MockBean
    private User user;

    @BeforeEach
    void setUp() {
        user=User.builder()
                .name("Vidura")
                .message("test")
                .build();
    }

    @Test
     public void createUser() throws Exception {
        User inputUser=User.builder()
                .name("Vidura")
                .message("test")
                .build();
        Mockito.when(userService.addNewStudent(inputUser)).thenReturn(user);
        mvc.perform(MockMvcRequestBuilders.post("")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"id\": \"1\",\n" +
                        "    \"name\": \"himantha\",\n" +
                        "    \"message\": \"test\"\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void getPlaces() {
    }

    @Test
    void getUserById() {

    }
}