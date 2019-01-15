package com.example.corewebmy2.storage;

import com.example.corewebmy2.exceptions.UserAlreadyExistException;
import com.example.corewebmy2.model.User;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class UserStorage {
    static Map<Long, User> users = new ConcurrentHashMap<>();
    AtomicInteger sequence = new AtomicInteger(0);

    public User save(User user) {
        Optional<User> ourUser = findUser(user.getUserName());
        if (ourUser.isPresent()) {
            throw new UserAlreadyExistException();
        }
        Long ourId = generateId();
        user.setId(ourId);
        users.put(ourId, user);
        return users.get(ourId);
    }

    public static Optional<User> findUser(String userName) {
        return users.values().stream()
                .filter(user -> user.getUserName().equals(userName)) //user - сами придумываем
                .findFirst();
    }
    public static Optional<User> findUserById(Long id) {
        return users.values().stream()
                .filter(user -> user.getId().equals(id)) //user - сами придумываем
                .findFirst();
    }


    long generateId() {
        return sequence.getAndIncrement();
    }

    public Map<Long, User> getUsers() {
        return users;
    }
}
