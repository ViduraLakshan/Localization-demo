package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(path = "/api/v1")
public class UserController {

    @Autowired
    private IUserService userService;
    private final MessageSource messageSource;
    public UserController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }




    @GetMapping("")
    public ResponseEntity<List<User>> getStudentList() {

        List<User> student = userService.getStudentList();
        return new ResponseEntity<List<User>>(student, HttpStatus.OK);

    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable(value = "id")Long id)
    {
        return userService.getUserById(id);
    }


    @PostMapping("")
    public User createUser(@RequestBody User user) {

        return userService.addNewStudent(user);
    }

    @GetMapping("/hello")
    public String hello(@RequestHeader(name = "Accept-Language",required = false) Locale locale)
    {
        return messageSource.getMessage("greeting",null,locale);
    }

    @GetMapping("/place")
    public String getPlaces(@RequestHeader(name = "Accept-Language",required = false) Locale locale)
    {
        return messageSource.getMessage("jaffna",null,locale);
    }
}
