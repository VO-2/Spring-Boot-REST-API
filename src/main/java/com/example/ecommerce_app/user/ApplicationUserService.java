package com.example.ecommerce_app.user;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ecommerce_app.util.Repositories;

@Service
@Transactional
public class ApplicationUserService implements UserDetailsService {

    private ApplicationUserRepository applicationUserRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
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
        applicationUser.setAccountNonExpired(true);
        applicationUser.setAccountNonLocked(true);
        applicationUser.setCredentialsNonExpired(true);
        applicationUser.setEnabled(true);
        applicationUser.setAuthorities(List.of(new SimpleGrantedAuthority("ROLE_USER")));
        return applicationUserRepository.save(applicationUser);
    }

    public ApplicationUser saveApplicationUser(ApplicationUser applicationUser) {
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

    @Override
    public ApplicationUser loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserRepository.findFirstByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("ApplicationUser '%s' not found", username)));
    }
    
}
