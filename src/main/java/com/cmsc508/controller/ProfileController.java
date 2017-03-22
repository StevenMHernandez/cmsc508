package com.cmsc508.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileController {
    @RequestMapping(value="/profile", method=RequestMethod.GET)
    public String index(Model model) {
        // send authenticated user data to view
        return "profile/index";
    }

    @RequestMapping(value="/profile", method=RequestMethod.POST)
    public String update(Model model) {
        // store new profile data to database
        // redirect to index
        return "redirect";
    }
}
