package pl.javalearn.weekop.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest implements ModelTest {

    static private User user;

    @BeforeAll
    static void getInstance() {
        user = new User();
    }
    
    @Test
    void givenUserProps_whenEqual_thenCorrect() {
        long id = 1;
        String username = "testUserName";
        String email = "test@email.com";
        String password = "passwordTest";
        boolean active = false;

        user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setActive(active);
        
        assertAll("Test user props set",
                () -> assertEquals(id, user.getId(), "Invalid ID"),
                () -> assertEquals(username, user.getUsername(), "Invalid USERNAME"),
                () -> assertEquals(email, user.getEmail(), "Invalid EMAIL"),
                () -> assertEquals(password, user.getPassword(), "Invalid PASSWORD"),
                () -> assertEquals(active, user.isActive(), "Invalid active"));
    }

    @Test
    void givenConstructorUser_whenPropsEqual_thenCorrect() {
        User constructorUser = new User(user);
        assertEquals(user, constructorUser, "Users are equals");

        assertAll("Test constructor user props set",
                () -> assertEquals(constructorUser.getId(), user.getId(), "Invalid ID"),
                () -> assertEquals(constructorUser.getUsername(), user.getUsername(), "Invalid USERNAME"),
                () -> assertEquals(constructorUser.getEmail(), user.getEmail(), "Invalid EMAIL"),
                () -> assertEquals(constructorUser.getPassword(), user.getPassword(), "Invalid PASSWORD"),
                () -> assertEquals(constructorUser.isActive(), user.isActive(), "Invalid active"));
    }

}