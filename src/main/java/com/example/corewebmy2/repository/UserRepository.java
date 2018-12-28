package com.example.corewebmy2.repository;

import com.example.corewebmy2.exceptions.UserAlreadyExistException;
import com.example.corewebmy2.model.User;

import java.util.Map;

public interface UserRepository {

    User save(User user) throws UserAlreadyExistException;

    Map<Long, User> get();

    User getById(Long id);
}
