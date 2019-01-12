package com.example.corewebmy2.service;

import com.example.corewebmy2.exceptions.UserAlreadyExistException;
import com.example.corewebmy2.model.User;
import com.example.corewebmy2.repository.UserRepository;
import com.example.corewebmy2.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UserService implements UserRepository {

    @Autowired
    UserStorage userStorage;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public User save(User user) throws UserAlreadyExistException {
        user.setHashedPassword(passwordEncoder.encode(user.getPassword()));
        return userStorage.save(user);
    }

    @Override
    public Map<Long, User> get() {
        return userStorage.getUsers();
    }

    @Override
    public User getById(Long id) {
        return UserStorage.findUserById(id).get();
    }
}