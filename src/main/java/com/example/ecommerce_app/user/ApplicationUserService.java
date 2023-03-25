package com.example.ecommerce_app.user;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ecommerce_app.util.Repositories;

@Service
@Transactional
public class ApplicationUserService {

    private ApplicationUserRepository applicationUserRepository;
    private PasswordEncoder passwordEncoder;

    public ApplicationUserService(ApplicationUserRepository applicationUserRepository, PasswordEncoder passwordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ApplicationUser getApplicationUser(Long applicationUserId) {
        return Repositories.getEntityById(applicationUserRepository, applicationUserId);
    }

    public List<ApplicationUser> getAllApplicationUsers() {
        return applicationUserRepository.findAll();
    }

    public ApplicationUser saveNewApplicationUser(ApplicationUser applicationUser) {
        applicationUser.setPassword(passwordEncoder.encode(applicationUser.getPassword()));
        return applicationUserRepository.save(applicationUser);
    }

    public ApplicationUser updateApplicationUser(ApplicationUser applicationUser) {
        if (applicationUserRepository.existsById(applicationUser.getUser_id())) {
            return applicationUserRepository.save(applicationUser);
        }
        else {
            throw new IllegalStateException("User with userId '" + applicationUser.getUser_id() + "' does not exist");
        }
    }

    public void deleteApplicationUser(Long ApplicationUserId) {
        applicationUserRepository.deleteById(ApplicationUserId);
    }

    public void deleteApplicationUser(ApplicationUser ApplicationUser) {
        applicationUserRepository.delete(ApplicationUser);
    }
    
}
