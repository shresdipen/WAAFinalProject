
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
    private UserRepository userrepository;
    
    @Override
    public void save(User user) {
//        user.setUsername("username");
//        user.setPassword("password");
//        user.setFirstname("firstname");
//        user.setLastname("lastname");
//        user.setAge(0);
//        user.setDateofbirth(new Date());
//        user.setGender("gender");
//        user.setAddress(new Address("country", "state", "highschool", "college", "nationality"));
        
    userrepository.save(user);

    }

    @Override
    public User findByUsername(String username) {
   
    return userrepository.findUserByName(username);
            
    }

    @Override
    public List<User> getAllusers() {
    return userrepository.getAllusers();
    }
  
}
