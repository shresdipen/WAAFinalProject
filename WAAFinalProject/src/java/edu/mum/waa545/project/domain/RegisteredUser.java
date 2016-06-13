/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa545.project.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kb
 */
@Repository
public class RegisteredUser {

    @Autowired
    private User user;// = new User("selam",20);
    private List<User> friends = new ArrayList<>();

    public RegisteredUser() {
//        User u1 = new User("kk", 12);
//        User u2 = new User("kk", 12);
//        User u3 = new User("kk", 12);
//        User u4 = new User("kk", 12);
//        User u5 = new User("kk", 12);
//
//        friends.add(u1);
//        friends.add(u2);
//        friends.add(u3);
//        friends.add(u4);
//        friends.add(u5);
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
