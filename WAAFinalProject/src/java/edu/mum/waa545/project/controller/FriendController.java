/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa545.project.controller;

import edu.mum.waa545.project.model.User;
import edu.mum.waa545.project.service.FriendService;
import edu.mum.waa545.project.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author kb
 */
@Controller
public class FriendController extends AbstractController {

    @Autowired
    FriendService friends;

    @Autowired
    UserService users;
    public FriendController() {
    }

//    @RequestMapping("/index")
//    public String friends(Model model) {
//        List<User> friend = friends.getFriends(name);
//
//        model.addAttribute("friends", friend);
//
//        return "index";
//    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getFriends(@RequestParam("name") String name, Model model) {

        model.addAttribute("friends", friends.getFriendsOnly(name));
        model.addAttribute("user", friends.getUser(name));
        //model.addAttribute("users",friends.searchUsers(name));
        //model.addAttribute("notFriend", friends.suggestFriends(name));
        model.addAttribute("suggested", friends.suggestFriends(name));
        
        return "users";
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String getAllFriends(@RequestParam("names") String name,@ModelAttribute("newFriend") User user, Model model) {

        friends.addFriend(user);
        model.addAttribute("friends", friends.getFriendsOnly(name));
        model.addAttribute("user", friends.getUser(name));
        //model.addAttribute("users",friends.searchUsers(name));
        //model.addAttribute("notFriend", friends.suggestFriends(name));
        model.addAttribute("suggested", friends.suggestFriends(name));
        
        return "users";
    }
    

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
