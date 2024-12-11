package com.norstarphoenix.neurowavecapstone.controller;

import com.norstarphoenix.neurowavecapstone.models.Group;
import com.norstarphoenix.neurowavecapstone.models.User;
import com.norstarphoenix.neurowavecapstone.services.GroupService;
import com.norstarphoenix.neurowavecapstone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;
    private final UserService userService;

    @Autowired
    public GroupController(GroupService groupService, UserService userService) {
        this.groupService = groupService;
        this.userService = userService;
    }

    // List all groups
    @GetMapping
    public String listGroups(Model model) {
        List<Group> groups = groupService.findAll();
        model.addAttribute("/groups", groups);
        return "redirect:/groups"; // Refers to a groups.html template
    }

    @PostMapping("/assignGroup")
    public String assignGroup(@RequestParam Long userId, @RequestParam String groupName) {
        User user = userService.getUserByIdOrThrow(userId); // Retrieves the user or throws an exception
        Group group = groupService.findGroupByName(groupName);

        if (group != null) {
            user.getGroups().add(group);
            userService.saveUser(user);
        } else {
            throw new IllegalArgumentException("Group " + groupName + " not found");
        }

        return "redirect:/groups";
    }

    // Create a new group
    @PostMapping("/create")
    public String createGroup(@RequestParam String name, Model model) {
        Group group = new Group();
        group.setName(name);
        groupService.saveGroup(group);
        model.addAttribute("message", "Group created successfully!");
        return "redirect:/groups";
    }
}
