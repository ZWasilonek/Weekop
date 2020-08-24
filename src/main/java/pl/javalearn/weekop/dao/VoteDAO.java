package pl.javalearn.weekop.dao;
 
import pl.javalearn.weekop.model.Vote;

public interface VoteDAO extends GenericDAO<Vote, Long> {
 
    public Vote getVoteByUserIdDiscoveryId(long userId, long discoveryId);

}