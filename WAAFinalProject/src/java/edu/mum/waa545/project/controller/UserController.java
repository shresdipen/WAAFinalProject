/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa545.project.controller;

import edu.mum.waa545.project.domain.Friends;
import edu.mum.waa545.project.domain.RegisteredUser;
import edu.mum.waa545.project.domain.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author kb
 */
@Controller
public class UserController extends AbstractController {

//    @Autowired
//    RegisteredUser registered;
    @Autowired
    Friends friends;
    
    public UserController() {
    }

//    @RequestMapping("/users")
//    public String users(Model model) {
//
//        List<User> users = registered.getFriends();
//
//        model.addAttribute("users", users);
//        
//        return "users";
//    }
    @RequestMapping("/index")
    public String friends(Model model) {
        List<RegisteredUser> friend = friends.getFriends();
        
        model.addAttribute("friends", friend);
        
        return "index";
    }

    @RequestMapping(value = "/users")
    public String getFriends(@RequestParam("name") String name,Model model) {
        //user.setUserName("helen");
        List<User> friend = friends.getFrindsOnly(name);
        
        model.addAttribute("friends", friend);
        return "users";
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
}
