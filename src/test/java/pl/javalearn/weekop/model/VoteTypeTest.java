package pl.javalearn.weekop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VoteTypeTest implements ModelTest {

    @Test
    void givenVoteType_whenPropEqual_thenCorrect() {
        VoteType voteType = VoteType.valueOf(VoteType.VOTE_DOWN.name());
        String type = "VOTE_DOWN";

        assertEquals(type, voteType.toString());
    }

}