package com.cmsc508.controller;

import com.cmsc508.model.Activity;
import com.cmsc508.repository.ActivitiesRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ActivityFeedController extends BaseController {
    @RequestMapping(value="/activity-feed", method=RequestMethod.GET)
    public String index(Model model) {
        List<Activity> activities = new ActivitiesRepository(this.jdbcTemplate).newest(this.getStudent().getId());

        model.addAttribute("activities", activities);

        return "activityfeed/index";
    }
}
