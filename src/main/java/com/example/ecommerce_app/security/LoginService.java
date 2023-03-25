package com.example.ecommerce_app.security;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ecommerce_app.user.ApplicationUser;
import com.example.ecommerce_app.user.ApplicationUserRepository;

@Service
@Transactional
public class LoginService {

    private ApplicationUserRepository applicationUserRepository;
    private PasswordEncoder passwordEncoder;

    public LoginService(ApplicationUserRepository applicationUserRepository, PasswordEncoder passwordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Checks if user-password combination from input can be found in database
     * @param user
     * @return
     */
    public ApplicationUser login(ApplicationUser user) {
        ApplicationUser storedUser = applicationUserRepository.findFirstByEmail(user.getEmail()).orElseThrow();

        if (passwordEncoder.matches(user.getPassword(), storedUser.getPassword())) {
            return storedUser;
        }
        else {
            throw new IllegalArgumentException("Input password does not match stored password for user: " + user.getEmail());
        }
    }
}
