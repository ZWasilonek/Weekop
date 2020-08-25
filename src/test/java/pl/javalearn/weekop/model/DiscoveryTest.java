package pl.javalearn.weekop.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.Timestamp;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscoveryTest implements ModelTest {

    static private Discovery discovery;
    private static long id = 1;
    private static String name = "test name";
    private static String description = "test description";
    private static String url = "https://github.com/ZWasilonek/Weekop";
    private static Timestamp time = new Timestamp(new Date().getTime());
    private static User user = new User();
    private static int upVote = 1;
    private static int downVote = -1;

    @BeforeAll
    static void getInstance() {
        discovery = new Discovery();

        discovery.setId(id);
        discovery.setName(name);
        discovery.setDescription(description);
        discovery.setUrl(url);
        discovery.setTimestamp(time);
        discovery.setUser(user);
        discovery.setUpVote(upVote);
        discovery.setDownVote(downVote);
    }

    @Test
    void givenDiscoveryProps_whenEqual_thenCorrect() {
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

    @Test
    void givenDiscoveryObjs_whenEqual_thenCorrect() {
        Discovery constructorDiscovery = new Discovery(discovery);
        assertEquals(constructorDiscovery, discovery);
        assertEquals(constructorDiscovery.hashCode(), discovery.hashCode());
        assertEquals(constructorDiscovery.toString(), discovery.toString());
    }

}