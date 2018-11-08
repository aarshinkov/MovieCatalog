package com.aarshinkov.controllers;

import com.aarshinkov.utils.Breadcrumb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private Logger log = LoggerFactory.getLogger(getClass());

    private static final String GLOBAL_MENU = "admin";

    @Autowired
    private MessageSource messageSource;

    @GetMapping
    public String admin(Model model) {

        model.addAttribute("globalMenu", GLOBAL_MENU);

        List<Breadcrumb> breadcrumbs = new ArrayList<>();
        breadcrumbs.add(new Breadcrumb("Admin", "/admin"));
        model.addAttribute("breadcrumbs", breadcrumbs);

        return "admin/admin";
    }



    @GetMapping(value = "/movies")
    public String movies(Model model) {

        model.addAttribute("globalMenu", GLOBAL_MENU);

        List<Breadcrumb> breadcrumbs = new ArrayList<>();
        breadcrumbs.add(new Breadcrumb("Admin", "/admin"));
        breadcrumbs.add(new Breadcrumb("Movies", "/admin/movies"));
        model.addAttribute("breadcrumbs", breadcrumbs);

        return "admin/movies/movies";
    }

    @GetMapping(value = "/movies/add")
    public String prepareAddMovie(Model model) {

        model.addAttribute("globalMenu", GLOBAL_MENU);

        List<Breadcrumb> breadcrumbs = new ArrayList<>();
        breadcrumbs.add(new Breadcrumb("Admin", "/admin"));
        breadcrumbs.add(new Breadcrumb("Movies", "/admin/movies"));
        breadcrumbs.add(new Breadcrumb("Add", "/admin/movies/add"));
        model.addAttribute("breadcrumbs", breadcrumbs);

        return "admin/movies/addMovie";
    }


    @GetMapping(value = "/users")
    public String users(Model model) {

        model.addAttribute("globalMenu", GLOBAL_MENU);

        List<Breadcrumb> breadcrumbs = new ArrayList<>();
        breadcrumbs.add(new Breadcrumb("Admin", "/admin"));
        breadcrumbs.add(new Breadcrumb("Users", "/admin/users"));
        model.addAttribute("breadcrumbs", breadcrumbs);

        return "admin/users/users";
    }


    @GetMapping(value = "/users/add")
    public String prepareAddUser(Model model) {

        model.addAttribute("globalMenu", GLOBAL_MENU);

        List<Breadcrumb> breadcrumbs = new ArrayList<>();
        breadcrumbs.add(new Breadcrumb("Admin", "/admin"));
        breadcrumbs.add(new Breadcrumb("Users", "/admin/users"));
        breadcrumbs.add(new Breadcrumb("Add", "/admin/users/add"));
        model.addAttribute("breadcrumbs", breadcrumbs);

        return "admin/users/addUser";
    }

}
