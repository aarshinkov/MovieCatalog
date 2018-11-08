package com.aarshinkov.controllers;

import com.aarshinkov.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "/login")
    public String login(Model model) {
        model.addAttribute("globalMenu", "login");

        return "login/login";
    }

    @GetMapping(value = "/signup")
    public String prepareSignup(Model model) {

        User user = new User();

        model.addAttribute("globalMenu", "signup");
        model.addAttribute("user", user);

        return "login/signup";
    }
}
