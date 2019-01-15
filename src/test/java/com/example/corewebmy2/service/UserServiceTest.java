package com.example.corewebmy2.service;

import com.example.corewebmy2.exceptions.UserAlreadyExistException;
import com.example.corewebmy2.model.User;
import org.junit.After;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@SpringBootTest
public class UserServiceTest {
    private static final String TEST_USER_NAME ="testUserName";
    private static final String TEST_FIRST_NAME ="testFirstName";
    private static final String TEST_LAST_NAME ="testLastName";
    private static final String TEST_PASSWORD ="testPassword";
    private static final Long TEST_ID =2L;

    @Resource
    UserService userService;

    @Test
    void testCorrectPersistUser(){
        User savedUser = userService.save(mockedUser());
        assertEquals("persist error", 1L, savedUser.getId().longValue());
        assertNotNull("password error",savedUser.getHashedPassword());
    }

    @Test
    void testCorrectPersistUser2(){
        User savedUser = userService.save(mockedUser());
        assertEquals("persist error", 1L, savedUser.getId().longValue());
        assertNotNull("password error",savedUser.getHashedPassword());
    }

    @Test(expected = UserAlreadyExistException.class)
    void testThrowException(){

        User savedUser = userService.save()
        assertEquals("", 1L, savedUser.getId().longValue());
        assertNotNull("",);
    }

    @Test
    public void testGetUserByIdSucsess() {
        User savedUser = userService.save(mockedUser());
        savedUser=userService.getById(mockedUser().getId());
        assertEquals("", "testUserName", savedUser.getUserName());
        assertEquals("", "testFirstName", savedUser.getFirstName());
        assertEquals("", "testLastName", savedUser.getLastName());
        assertEquals("", "testPassword", savedUser.getHashedPassword());
        assertEquals("", 1L, savedUser.getId().longValue());

    }

    @After
    public void cleanUp() throws Exception {
    }



    User mockedUser(){
        return User.of().firstName(TEST_FIRST_NAME).id(TEST_ID).lastName(TEST_LAST_NAME).userName(TEST_USER_NAME).password(TEST_PASSWORD)
                .create();
    }

}