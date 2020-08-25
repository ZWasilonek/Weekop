package pl.javalearn.weekop.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Date;
import java.sql.Timestamp;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class VoteTest implements ModelTest {

    static private Vote vote;

    @BeforeAll
    static void getInstance() {
        vote = new Vote();
    }

    @DisplayName("Method Provider Objects Equal Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getObjProps")
    void givenVoteObjs_whenEqual_thenCorrect(long id, long discoveryId, long userId, Timestamp date, VoteType voteType) {
        vote.setId(id);
        vote.setDiscoveryId(discoveryId);
        vote.setUserId(userId);
        vote.setDate(date);
        vote.setVoteType(voteType);

        Vote constructorVote = new Vote(vote);
        assertEquals(vote, constructorVote);
        assertEquals(constructorVote.hashCode(), vote.hashCode());
        assertEquals(constructorVote.toString(), vote.toString());
    }

    @DisplayName("Method Provider Props Equal Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getObjProps")
    void givenMethodSourceProps_whenEqual_thenCorrect(long id, long discoveryId, long userId, Timestamp date, VoteType voteType) {
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

    static Stream<Arguments> getObjProps() {
        long id = 1;
        long discoveryId = 1;
        long userId = 1;
        Timestamp date = new Timestamp(new Date().getTime());
        VoteType voteType = VoteType.VOTE_DOWN;

        return Stream.of(
                Arguments.of(id, discoveryId, userId, date, voteType),
                Arguments.of(2, 3, 3, date, voteType),
                Arguments.of(7, 2, 1, date, VoteType.VOTE_UP));
    }

}