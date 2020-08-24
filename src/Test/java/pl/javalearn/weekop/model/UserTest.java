package pl.javalearn.weekop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest implements ModelTest {
    
    @Test
    void givenUser_whenNotNull_thenCorrect() {
        long id = 1;
        String username = "testUserName";
        String email = "test@email.com";
        String password = "passwordTest";
        boolean active = true;

        User user = new User();
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

}