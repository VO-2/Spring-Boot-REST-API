package com.example.ecommerce_app.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {

    private ApplicationUserRepository applicationUserRepository;

    public ApplicationUserService(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = null;

        try {
            applicationUser = applicationUserRepository.findByUsername(username).get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new UsernameNotFoundException(String.format("ApplicationUser '%s' not found", username));
        }

        return applicationUser;
    }
    
}
