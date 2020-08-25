package pl.javalearn.weekop.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class VoteTest implements ModelTest {

    static private Vote vote;

    @BeforeAll
    static void getInstance() {
        vote = new Vote();
    }

    @Test
    void givenVote_whenPropsEqual_thenCorrect() {
        long id = 1;
        long discoveryId = 1;
        long userId = 1;
        Timestamp date = new Timestamp(new Date().getTime());
        VoteType voteType = VoteType.VOTE_DOWN;

        vote.setId(id);
        vote.setDiscoveryId(discoveryId);
        vote.setUserId(userId);
        vote.setDate(date);
        vote.setVoteType(voteType);

        assertAll("Test vote props set",
                () -> assertEquals(id, vote.getId(), "Invalid ID"),
                () -> assertEquals(discoveryId, vote.getDiscoveryId(), "Invalid DISCOVERY_ID"),
                () -> assertEquals(userId, vote.getUserId(), "Invalid USER_ID"),
                () -> assertEquals(date, vote.getDate(), "Invalid DATE"),
                () -> assertEquals(voteType, vote.getVoteType(), "Invalid VOTE_TYPE"));
    }

    @Test
    void givenConstructorVote_whenPropsEqual_thenCorrect() {
        Vote constructorVote = new Vote(vote);
        assertEquals(vote, constructorVote);

        assertAll("Test vote props set",
                () -> assertEquals(constructorVote.getId(), vote.getId(), "Invalid ID"),
                () -> assertEquals(constructorVote.getDiscoveryId(), vote.getDiscoveryId(), "Invalid DISCOVERY_ID"),
                () -> assertEquals(constructorVote.getUserId(), vote.getUserId(), "Invalid USER_ID"),
                () -> assertEquals(constructorVote.getDate(), vote.getDate(), "Invalid DATE"),
                () -> assertEquals(constructorVote.getVoteType(), vote.getVoteType(), "Invalid VOTE_TYPE"));
    }

}