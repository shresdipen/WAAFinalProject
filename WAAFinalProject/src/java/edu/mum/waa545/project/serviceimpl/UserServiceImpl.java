package edu.mum.waa545.project.serviceimpl;

import edu.mum.waa545.project.db.UserRepository;
import edu.mum.waa545.project.model.Address;
import edu.mum.waa545.project.model.RegisteredUser;
import edu.mum.waa545.project.model.User;
import edu.mum.waa545.project.service.UserService;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userrepository;
    
    @Autowired
    private RegisteredUser reguser;

    @Override
    public void save(User user) {
        userrepository.save(user);
        reguser.setUser(user);

    }

    @Override
    public User findByUsername(String username) {
        User user = userrepository.findUserByName(username);
        return user;

    }

    @Override
    public List<User> getAllusers() {
        return userrepository.getAllusers();
    }

    @Override
    public boolean checkDuplicate(String username) {

        User user = userrepository.findUserByName(username);
        if (!(user == null)) {
            if (username.equalsIgnoreCase(user.getUsername())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
