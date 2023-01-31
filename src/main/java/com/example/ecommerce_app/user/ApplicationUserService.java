package com.example.ecommerce_app.user;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ecommerce_app.util.Repositories;

@Service
@Transactional
public class ApplicationUserService implements UserDetailsService {

    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    public ApplicationUserService(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    public ApplicationUser getApplicationUser(Long applicationUserId) {
        return Repositories.getEntityById(applicationUserRepository, applicationUserId);
    }

    public List<ApplicationUser> getAllApplicationUsers() {
        return applicationUserRepository.findAll();
    }

    public ApplicationUser saveApplicationUser(ApplicationUser ApplicationUser) {
        return applicationUserRepository.save(ApplicationUser);
    }

    public void deleteApplicationUser(Long ApplicationUserId) {
        applicationUserRepository.deleteById(ApplicationUserId);
    }

    public void deleteApplicationUser(ApplicationUser ApplicationUser) {
        applicationUserRepository.delete(ApplicationUser);
    }

    @Override
    public ApplicationUser loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserRepository.findFirstByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("ApplicationUser '%s' not found", username)));
    }
    
}
