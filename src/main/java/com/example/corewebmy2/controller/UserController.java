package com.example.corewebmy2.controller;

import com.example.corewebmy2.dto.UserDto;
import com.example.corewebmy2.model.User;
import com.example.corewebmy2.repository.UserRepository;
import com.example.corewebmy2.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.awt.*;
import java.util.Map;
import java.util.Optional;

import static com.example.corewebmy2.dto.UserDto.UserDtoInterface.toUserDto;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserDto addUser(@RequestBody @Valid User user) {
        return toUserDto(userRepository.save(user));
    }

    @GetMapping(value = "/get", produces = APPLICATION_JSON_VALUE)
    Map<Long, User> getUsers() {
        return userRepository.get();

    }@GetMapping(value = "/get/{id}", produces = APPLICATION_JSON_VALUE)
    User getUsersById(Long id) {
        return userRepository.getById(id);
    }



}
