
package edu.mum.waa545.project.service;

import edu.mum.waa545.project.model.User;
import java.util.List;


public interface UserService {
    void save(User user);
    User findByUsername(String username);
    List<User> getAllusers();
  
    //this is a service level method since its a service used by everyone
    boolean checkDuplicate(String username);
}
