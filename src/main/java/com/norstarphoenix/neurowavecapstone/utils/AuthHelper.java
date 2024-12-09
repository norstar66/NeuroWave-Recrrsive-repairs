package com.norstarphoenix.neurowavecapstone.utils;

package com.norstarphoenix.neurowavecapstone.helpers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthHelper {

    private final PasswordEncoder passwordEncoder;

    public AuthHelper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Validates the user's password against the stored hashed password.
     * @param storedPasswordHash The hashed password stored in the database.
     * @param inputPassword The raw password entered by the user.
     * @return True if the passwords match, otherwise false.
     */
    public boolean validatePassword(String storedPasswordHash, String inputPassword) {
        return passwordEncoder.matches(inputPassword, storedPasswordHash);
    }
}
