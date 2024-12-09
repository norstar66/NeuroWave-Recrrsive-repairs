package com.norstarphoenix.neurowavecapstone.controller;

import com.norstarphoenix.neurowavecapstone.models.Group;
import com.norstarphoenix.neurowavecapstone.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    private final GroupService groupService;

    @Autowired
    public PageController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/groups")
    public String showGroupsPage(Model model) {
        model.addAttribute("groups", groupService.findAllGroups());
        return "groups"; // Refers to groups.html in templates
    }

    // Mapping for the home page
    @GetMapping("/")
    public String homePage() {
        return "index"; // Refers to index.html in src/main/resources/templates
    }

    // Mapping for the adventures page
    @GetMapping("/adventures")
    public String adventuresPage() {
        return "adventures"; // Refers to adventures.html in src/main/resources/templates
    }

    // Mapping for the investors page
    @GetMapping("/investors")
    public String investorsPage() {
        return "investors"; // Refers to investors.html in src/main/resources/templates
    }
}
