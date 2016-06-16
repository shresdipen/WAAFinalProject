/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa545.project.controller;

import edu.mum.waa545.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author rajiv
 */
@Controller
public class LoginController {
    
    @Autowired
    UserService userService;
    
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String getLoginPage() {
        System.out.println("From Login: "+userService.getAllusers());
        return "login";
    }
}