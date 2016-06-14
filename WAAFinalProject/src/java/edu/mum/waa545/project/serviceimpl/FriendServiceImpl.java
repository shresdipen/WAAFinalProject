/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa545.project.serviceimpl;

import edu.mum.waa545.project.db.FriendDB;
import edu.mum.waa545.project.db.UserRepository;
import edu.mum.waa545.project.model.RegisteredUser;
import edu.mum.waa545.project.model.User;
import edu.mum.waa545.project.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.mum.waa545.project.service.FriendService;
import java.util.ArrayList;

/**
 *
 * @author kb
 */
@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    RegisteredUser regUser;

    @Autowired
    UserService userService;

    @Autowired
    FriendDB friend;

    @Autowired
    UserRepository users;

    @Override
    public void addFriend(User user) {

        regUser.getFriends().add(user);
    }

    @Override
    public List<User> getFriendsOnly(String userName) {

        List<RegisteredUser> allUsers = new ArrayList<>();

        allUsers = friend.getFriends();

        for (RegisteredUser user : allUsers) {

            if (user.getUser().getUsername().equalsIgnoreCase(userName)) {
                return user.getFriends();
            }
        }

        return null;
    }

    @Override
    public List<User> getAllUsers() {

        return userService.getAllusers();
    }

    @Override
    public User getUser(String userName) {

        List<RegisteredUser> allUsers = new ArrayList<>();

        allUsers = friend.getFriends();

        for (RegisteredUser user : allUsers) {

            if (user.getUser().getUsername().equalsIgnoreCase(userName)) {
                return user.getUser();
            }
        }
        return null;
    }

    @Override
    public List<User> searchUsers(String firstName) {

        List<User> listUser = new ArrayList<>();
        List<User> allUsers = users.getAllusers();

        for (User user : allUsers) {
            if (user.getFirstname().equalsIgnoreCase(firstName)) {
                listUser.add(user);
            }
        }

        return listUser;
    }

    @Override
    public List<User> suggestFriends(String userName) {

        User user = userService.findByUsername(userName);;
        List<User> notFriends = notFriends(userName);
        List<User> suggestedFriends = new ArrayList<>();
        List<User> suggestedByState = new ArrayList<>();
        List<User> suggested = new ArrayList<>();

        for (User nFriend : notFriends) {
            if (user.getAddress().getCountry().equalsIgnoreCase(nFriend.getAddress().getCountry())) {
                suggestedFriends.add(nFriend);
            }
        }
         
        if (suggestedFriends.size() > 5) {
           
            for (User nFriend : suggestedFriends) {
                if ((user.getAddress().getState().equalsIgnoreCase(nFriend.getAddress().getState()))) {
                    suggestedByState.add(nFriend);
                }
//                if (suggestedByState.size() > 5) {
//                    break;
//                }
            }
        }
        
        if (suggestedByState.size() > 5) {
            
            for (User nFriend : suggestedByState) {
                if ((user.getAddress().getHighschool().equalsIgnoreCase(nFriend.getAddress().getHighschool()))) {
                    suggested.add(nFriend);
                }
            }
        }

        return suggested;
    }

    public List<User> notFriends(String userName) {

        List<User> userList = getAllUsers();
        List<User> friendsList = getFriendsOnly(userName);
        List<User> notFriends = userList;

        for (User friend : friendsList) {
            for (User user : userList) {
                if (friend.equals(user)) {
                    notFriends.remove(user);
                }
            }
        }
        return notFriends;
    }

    @Override
    public User getByUserByUserName(String userName) {

        User users = userService.findByUsername(userName);
        return userService.findByUsername(userName);
    }

}