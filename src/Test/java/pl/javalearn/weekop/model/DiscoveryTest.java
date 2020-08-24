package pl.javalearn.weekop.model;

import org.junit.jupiter.api.Test;
import java.sql.Timestamp;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscoveryTest implements ModelTest {

    @Test
    void givenDiscovery_whenNotNull_thenCorrect() {
        long id = 1;
        String name = "test name";
        String description = "test description";
        String url = "https://github.com/ZWasilonek/Weekop";
        Timestamp time = new Timestamp(new Date().getTime());
        User user = new User();
        int upVote = 1;
        int downVote = -1;

        Discovery discovery = new Discovery();
        discovery.setId(id);
        discovery.setName(name);
        discovery.setDescription(description);
        discovery.setUrl(url);
        discovery.setTimestamp(time);
        discovery.setUser(user);
        discovery.setUpVote(upVote);
        discovery.setDownVote(downVote);

        assertAll("Test discovery props set",
                () -> assertEquals(id, discovery.getId(), "Invalid ID"),
                () -> assertEquals(name, discovery.getName(), "Invalid NAME"),
                () -> assertEquals(description, discovery.getDescription(), "Invalid DESCRIPTION"),
                () -> assertEquals(url, discovery.getUrl(), "Invalid URL"),
                () -> assertEquals(time, discovery.getTimestamp(), "Invalid TIME"),
                () -> assertEquals(user, discovery.getUser(), "Invalid USER"),
                () -> assertEquals(upVote, discovery.getUpVote(), "Invalid UP_VOTE"),
                () -> assertEquals(downVote, discovery.getDownVote(), "Invalid DOWN_VOTE"));
    }

}