package pl.javastart.weekop.dao.factory;

import pl.javastart.weekop.dao.*;
import pl.javastart.weekop.dao.impl.DiscoveryDAOImpl;
import pl.javastart.weekop.dao.impl.UserDAOImpl;
import pl.javastart.weekop.dao.impl.VoteDAOImpl;

public class MysqlDAOFactory extends DAOFactory {
 
    @Override
    public DiscoveryDAO getDiscoveryDAO() {
        return new DiscoveryDAOImpl();
    }
 
    @Override
    public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }
 
    @Override
    public VoteDAO getVoteDAO() {
        return new VoteDAOImpl();
    }
 
}