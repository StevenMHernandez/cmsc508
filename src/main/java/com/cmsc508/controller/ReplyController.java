package com.cmsc508.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReplyController {
    @RequestMapping(value="/comment/{comment_id}/reply", method=RequestMethod.POST)
    public String reply(@PathVariable Integer comment_id, Model model) {
        // store reply in database
        // redirect to index
        return "redirect";
    }
}
