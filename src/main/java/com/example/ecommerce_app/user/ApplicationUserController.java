package com.example.ecommerce_app.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/user")
public class ApplicationUserController {

    private ApplicationUserService applicationUserService;

    @Autowired
    public ApplicationUserController(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @GetMapping("{applicationUserId}")
    public ApplicationUser getApplicationUser(@PathVariable Long applicationUserId) {
        return applicationUserService.getApplicationUser(applicationUserId);
    }

    @GetMapping
    public List<ApplicationUser> getAllApplicationUsers() {
        return applicationUserService.getAllApplicationUsers();
    }

    @PostMapping
    public ApplicationUser createApplicationUser(@RequestBody ApplicationUser applicationUser) {
        return applicationUserService.saveNewApplicationUser(applicationUser);
    }

    @PutMapping
    public ApplicationUser updateApplicationUser(@RequestBody ApplicationUser applicationUser) {
        return applicationUserService.updateApplicationUser(applicationUser);
    }

    @DeleteMapping("{applicationUserId}")
    public void deleteApplicationUser(@PathVariable Long applicationUserId) {
        applicationUserService.deleteApplicationUser(applicationUserId);
    }
}
