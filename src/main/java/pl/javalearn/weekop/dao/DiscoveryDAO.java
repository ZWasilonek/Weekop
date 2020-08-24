package pl.javalearn.weekop.dao;
 
import java.util.List;
import pl.javalearn.weekop.model.Discovery;
 
public interface DiscoveryDAO extends GenericDAO<Discovery, Long>{
 
    List<Discovery> getAll();
     
}