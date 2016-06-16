/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa545.project.controller;

import edu.mum.waa545.project.model.RegisteredUser;
import edu.mum.waa545.project.model.User;
import edu.mum.waa545.project.service.FriendService;
import edu.mum.waa545.project.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
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

    @RequestMapping(value = "users.spring", method = RequestMethod.GET)
    public String getFriends(@RequestParam("name") String name, Model model) {

        model.addAttribute("friends", friends.getFriendsOnly(name));
        model.addAttribute("user", friends.getUser(name));
        //model.addAttribute("users",friends.searchUsers(name));
        //model.addAttribute("notFriend", friends.suggestFriends(name));
        model.addAttribute("suggested", friends.suggestFriends(name));

        return "users";
    }

    //@RequestMapping(value="newFriend", method = RequestMethod.GET)
//    public ModelAndView newFriend() {
//        return new ModelAndView("users", "newFriend", new User());
//    }

    @RequestMapping(value = "users.spring", method = RequestMethod.POST)
    public String getAllFriends(@RequestParam("names") String name, @RequestParam("newFriend") String userName, Model model) {

        User user = friends.getUserByUserName(userName);
        model.addAttribute("friends", friends.getFriendsOnly(name));
        model.addAttribute("user", friends.getUser(name));
        model.addAttribute("suggested", friends.suggestFriends(name));

        return "users";
    }

    
    
    @RequestMapping(value = "/addFriend.spring", method = RequestMethod.POST)
    public ModelAndView addFriend(HttpServletRequest request) {
        String newFriend = request.getParameter("newFriend");
        String userName = request.getParameter("regUser");
        RegisteredUser regUser = friends.getRegisteredUserByUserName(userName);
        User user = friends.getUserByUserName(newFriend);

        regUser.addFriend(user);
        request.setAttribute("friends", friends.getFriendsOnly(userName));
        request.setAttribute("suggested", friends.suggestFriends(userName));
        request.setAttribute("users", friends.searchUsers(userName));
        request.setAttribute("user", regUser.getUser());
        
        return new ModelAndView("redirect:/users.spring");
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
