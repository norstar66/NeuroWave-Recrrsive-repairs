package com.norstarphoenix.neurowavecapstone.services;

import com.norstarphoenix.neurowavecapstone.helpers.AuthHelper;
import com.norstarphoenix.neurowavecapstone.models.User;
import com.norstarphoenix.neurowavecapstone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuthHelper authHelper;

    @Autowired
    public UserService(UserRepository userRepository, AuthHelper authHelper) {
        this.userRepository = userRepository;
        this.authHelper = authHelper;
    }

    /**
     * Logs in a user by validating their credentials.
     * @param user The user attempting to log in.
     * @param model The model to add attributes for error messages.
     * @return True if the user is authenticated, otherwise false.
     */
    public boolean loginUser(User user, Model model) {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());

        if (optionalUser.isPresent()) {
            User storedUser = optionalUser.get();

            // Use AuthHelper to validate the password
            if (authHelper.validatePassword(storedUser.getPasswordHash(), user.getPassword())) {
                return true; // Successful authentication
            }
        }

        model.addAttribute("error", "Invalid username or password");
        return false; // Authentication failed
    }

    /**
     * Registers a new user by hashing their password before saving.
     * @param user The user to register.
     */
    public void registerUser(User user) {
        user.setPasswordHash(authHelper.getPasswordEncoder().encode(user.getPasswordHash()));
        userRepository.save(user);
    }
}
