
package edu.mum.waa545.project.serviceimpl;


import edu.mum.waa545.project.db.UserRepository;
import edu.mum.waa545.project.model.Address;
import edu.mum.waa545.project.model.User;
import edu.mum.waa545.project.service.UserService;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userrepository;
    
    @Override
    public void save(User user) {
        System.out.println("User from service: "+user);
    userrepository.save(user);
        System.out.println("From Service: "+userrepository.getAllusers());

    }

    @Override
    public User findByUsername(String username) {
   System.out.println("Find by username: "+userrepository.getAllusers());
    return userrepository.findUserByName(username);
            
    }

    @Override
    public List<User> getAllusers() {
    return userrepository.getAllusers();
    }

    @Override
    public boolean checkDuplicate(String username) {
    
    User user = userrepository.findUserByName(username);
    if(!(user==null)){
    if(username.equalsIgnoreCase(user.getUsername()))
        return true;
    else 
        return false;
        }
    else
        return false;  
    }

    @Override
    public User findByUsername(String username, UserRepository userRepository) {
        System.out.println("User Repo: "+userRepository.getAllusers());
        return userRepository.findUserByName(username);        
    }
 
}
