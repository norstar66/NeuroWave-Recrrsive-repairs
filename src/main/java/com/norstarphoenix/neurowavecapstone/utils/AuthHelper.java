package com.norstarphoenix.neurowavecapstone.utils;

import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Getter
@Component
public class AuthHelper {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean validatePassword(String storedHash, String inputPassword) {
        return passwordEncoder.matches(inputPassword, storedHash);
    }
}
