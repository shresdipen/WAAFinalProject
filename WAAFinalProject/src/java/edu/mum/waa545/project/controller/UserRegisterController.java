package edu.mum.waa545.project.controller;

import edu.mum.waa545.project.model.User;
import edu.mum.waa545.project.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class UserRegisterController {

    @Autowired
    private UserService userService;

   @RequestMapping("/register")
   public ModelAndView user(){
   
       return new ModelAndView("user","command",new User());
   }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String sinup(Model model) {
        //model.addAttribute("authority", authorityService.findAll());
        return "register";
    }

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    public String postSignup(@ModelAttribute("user") User user,Model model,BindingResult result) {

        System.out.println("SignUp checking...... ");
        model.addAttribute("tt", "Trial");

        if (result.hasErrors()) {
            return "register";
        }

        userService.save(user);
        return "welcome";
    }

//    @RequestMapping(value = "/register")
//    public String addUser(Model model) {
//        
//        model.addAttribute("users", userService.getAllusers());
//        model.addAttribute("", model);
//        
//        userService.save(loginForm);
//                
//        return "register";
//    }
}
