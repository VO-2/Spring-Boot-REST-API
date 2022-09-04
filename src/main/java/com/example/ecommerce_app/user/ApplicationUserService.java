package com.example.ecommerce_app.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {

    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    public ApplicationUserService(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    @Transactional
    public ApplicationUser loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserRepository.findFirstByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("ApplicationUser '%s' not found", username)));
    }
    
}
