package com.aarshinkov.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/error")
public class ErrorController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "/403")
    public String error403() {

        log.debug("Access denied! Redirecting to page 403");

        return "error/403";
    }

    @GetMapping(value = "/404")
    public String error404() {

        log.debug("Page not found! Redirecting to page 404");

        return "error/404";
    }

    @GetMapping(value = "/405")
    public String error405() {

        log.debug("Method not found! Redirecting to page 405");

        return "error/405";
    }

    @GetMapping(value = "/500")
    public String error500() {

        log.debug("Internal server error ! Redirecting to page 500");

        return "error/500";
    }

}
