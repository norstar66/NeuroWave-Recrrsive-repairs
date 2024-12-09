package com.norstarphoenix.neurowavecapstone.controller;

import com.norstarphoenix.neurowavecapstone.models.User;
import com.norstarphoenix.neurowavecapstone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UserService userService;

    // Constructor-based dependency injection
    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    // Mapping for the login page
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "login"; // Refers to login.html in src/main/resources/templates
    }

    // Mapping to handle login form submission
    @PostMapping("/login")
    public String processLogin(@ModelAttribute User user, Model model) {
        // Authenticate the user
        boolean isAuthenticated = userService.authenticate(user.getUsername(), user.getPassword());
        if (isAuthenticated) {
            return "redirect:/dashboard"; // Redirect to dashboard on successful login
        }
        model.addAttribute("error", "Invalid username or password");
        return "login"; // Show login page with error message
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute User user, Model model) {
        Optional<User> optionalUser = userService.findByEmail(user.getEmail());
        if (optionalUser.isPresent() && userService.authenticate(user.getUsername(), user.getPassword())) {
            User loggedInUser = optionalUser.get();
            Group adventureGroup = groupService.findGroupByName("adventure");
            loggedInUser.getGroups().add(adventureGroup); // Assign to group
            userService.saveUser(loggedInUser); // Save updates
            return "redirect:/dashboard";
        }
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }
}
