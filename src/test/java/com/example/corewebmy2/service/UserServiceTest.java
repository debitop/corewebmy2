package com.example.corewebmy2.service;

import com.example.corewebmy2.exceptions.UserAlreadyExistException;
import com.example.corewebmy2.model.User;
import com.example.corewebmy2.storage.UserStorage;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    private static final String TEST_USER_NAME = "testUserName";
    private static final String TEST_FIRST_NAME = "testFirstName";
    private static final String TEST_LAST_NAME = "testLastName";
    private static final String TEST_PASSWORD = "testPassword";
    private static final Long TEST_ID = 1L;

    @Resource
    UserService userService;

    @Test
    public void testCorrectPersistUser() {
        User user = mockedUser();
        User savedUser = userService.save(user);
        assertEquals("persist error", 1L, savedUser.getId().longValue());
        assertNotNull("password error", savedUser.getHashedPassword());
    }

    @Test
    public void testCorrectPersistUser2() {
        User savedUser = userService.save(mockedUser());
        assertEquals("persist error", 1L, savedUser.getId().longValue());
        assertNotNull("password error", savedUser.getHashedPassword());
    }

    @Test(expected = UserAlreadyExistException.class)
    public void testThrowException() {

        User savedUser = userService.save(mockedUser());
        assertEquals("", 1L, savedUser.getId().longValue());
        assertNotNull("",savedUser);
    }

    @Test
    public void testGetUserByIdSucsess() {
        User mokedUser =mockedUser();
        User savedUser = userService.save(mokedUser);
        assertNotNull(savedUser);
        savedUser = userService.getById(mokedUser.getId());
        assertEquals("", TEST_USER_NAME, savedUser.getUserName());
        assertEquals("", TEST_FIRST_NAME, savedUser.getFirstName());
        assertEquals("", TEST_LAST_NAME, savedUser.getLastName());
        assertEquals("", TEST_PASSWORD, savedUser.getPassword());
        assertEquals("", TEST_ID.longValue(), savedUser.getId().longValue());

    }

    @After
    public void cleanUp() throws Exception {
        UserStorage.users = new ConcurrentHashMap<>();
        UserStorage.sequence = new AtomicInteger(0);
    }


    User mockedUser() {
        return User.of()
                .firstName(TEST_FIRST_NAME)
                .id(TEST_ID)
                .lastName(TEST_LAST_NAME)
                .userName(TEST_USER_NAME)
                .password(TEST_PASSWORD)
                .create();
    }

}