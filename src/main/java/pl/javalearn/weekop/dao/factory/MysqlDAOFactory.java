package pl.javalearn.weekop.dao.factory;

import pl.javalearn.weekop.dao.DiscoveryDAO;
import pl.javalearn.weekop.dao.UserDAO;
import pl.javalearn.weekop.dao.VoteDAO;
import pl.javalearn.weekop.dao.impl.UserDAOImpl;
import pl.javalearn.weekop.dao.impl.DiscoveryDAOImpl;
import pl.javalearn.weekop.dao.impl.VoteDAOImpl;

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