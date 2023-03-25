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
        if (storedUser.getPassword() == passwordEncoder.encode(user.getPassword())) {
            return storedUser;
        }
        else {
            throw new IllegalArgumentException("Invalid password for user: " + user.getEmail());
        }
    }
}
