package pl.javalearn.weekop.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class VoteTypeTest implements ModelTest {

    @Test
    void givenVoteType_whenPropEqual_thenCorrect() {
        VoteType voteType = VoteType.valueOf(VoteType.VOTE_DOWN.name());
        String type = "VOTE_DOWN";

        assertEquals(type, voteType.toString());
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(VoteType.class)
    void enumTest(VoteType type) {
        System.out.println(type);
    }

}