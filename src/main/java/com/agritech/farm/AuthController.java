package com.agritech.farm.controller;

import com.agritech.farm.entity.User;
import com.agritech.farm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String loginPage() {
        return "login";
    }


    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.authenticate(username, password);
        if (user != null) {
            return "redirect:/greenhouses";
        }
        model.addAttribute("error", "Hatalı kullanıcı adı veya şifre!");
        return "login";
    }


    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }


    @PostMapping("/signup")
    public String signup(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/";
    }
}