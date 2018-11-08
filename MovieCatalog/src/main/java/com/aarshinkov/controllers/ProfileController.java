package com.aarshinkov.controllers;

import com.aarshinkov.utils.Breadcrumb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    private Logger log = LoggerFactory.getLogger(getClass());

    private static final String GLOBAL_MENU = "profile";

    @GetMapping
    public String profile(Model model) {

        model.addAttribute("globalMenu", GLOBAL_MENU);

        List<Breadcrumb> breadcrumbs = new ArrayList<>();
        breadcrumbs.add(new Breadcrumb("Profile", "/profile"));
        model.addAttribute("breadcrumbs", breadcrumbs);

        return "profile/general";
    }
}
