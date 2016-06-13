/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa545.project.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kb
 */

@Repository
public class Friends {

    private List<RegisteredUser> friends = new ArrayList<>();

    public Friends() {

        RegisteredUser reg1 = new RegisteredUser();

        List<User> u1s = Arrays.asList(new User("sele", 12), new User("shebe", 12));
        reg1.setFriends(u1s);
        reg1.setUser(new User("kebede", 12));

        RegisteredUser reg2 = new RegisteredUser();
        
        List<User> u2s = Arrays.asList(new User("kbc", 12), new User("fbc", 12));
        reg2.setFriends(u2s);
        reg2.setUser(new User("helen", 20));
        
        friends.add(reg1);
        friends.add(reg2);

    }

    public List<RegisteredUser> getFriends() {
        return friends;
    }

    public void setFriends(List<RegisteredUser> friends) {
        this.friends = friends;
    }

    public List<User> getFrindsOnly(String userName) {

        //List<User> friendList = new ArrayList<>();

        for (RegisteredUser reg : friends) {
            if (reg.getUser().getUserName().equals(userName)) {
                return reg.getFriends();
            }
        }

        return null;
    }

}
