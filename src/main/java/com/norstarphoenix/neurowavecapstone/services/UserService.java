package com.norstarphoenix.neurowavecapstone.services;

import com.norstarphoenix.neurowavecapstone.exceptions.UserNotFoundException;
import com.norstarphoenix.neurowavecapstone.utils.AuthHelper;
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

    // Existing methods...

    /**
     * Finds a user by their ID.
     *
     * @param id The ID of the user to find.
     * @return Optional containing the User if found, or empty if not found.
     */
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    // Existing methods remain unchanged
    public boolean loginUser(User user, Model model) {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());

        if (optionalUser.isPresent()) {
            User storedUser = optionalUser.get();

            if (authHelper.validatePassword(storedUser.getPasswordHash(), user.getPassword())) {
                return true; // Successful authentication
            }
        }

        model.addAttribute("error", "Invalid username or password");
        return false; // Authentication failed
    }

    public void registerUser(User user) {
        user.setPasswordHash(authHelper.getPasswordEncoder().encode(user.getPasswordHash()));
        userRepository.save(user);
    }

    public boolean authenticate(String username, String password) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return authHelper.validatePassword(user.getPasswordHash(), password);
        }
        return false;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUserByIdOrThrow(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User with ID " + id + " not found"));

    }
}
