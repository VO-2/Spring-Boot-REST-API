package com.example.ecommerce_app.user;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity()
@Table(
    name = "user",
    uniqueConstraints = {
        @UniqueConstraint(name = "UK_email", columnNames = "email"),
        @UniqueConstraint(name = "UK_username", columnNames = "username")
    }
)
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private Long id;

    @Size(min = 2, message = "username must be atleast 2 characters long")
    @Column(
        name = "username",
        columnDefinition = "VARCHAR(30)",
        nullable = false,
        unique = true
    )
    private String username;

    @Column(
        name = "password",
        columnDefinition = "BINARY(60)",
        nullable = false
    )
    private String password;

    @Email
    @Column(
        name = "email",
        columnDefinition = "VARCHAR(50)",
        nullable = false,
        unique = true
    )
    private String email;

    @Column(
        nullable = false
    )
    private boolean isAccountNonExpired;

    @Column(
        nullable = false
    )
    private boolean isAccountNonLocked;

    @Column(
        nullable = false
    )
    private boolean isCredentialsNonExpired;

    @Column(
        nullable = false
    )
    private boolean isEnabled;

    @ElementCollection
    @Column(
        nullable = false
    )
    private Collection<GrantedAuthority> authorities;

    public ApplicationUser() {}

    public ApplicationUser(
            String username,
            String password,
            String email,
            boolean isAccountNonExpired,
            boolean isAccountNonLocked,
            boolean isCredentialsNonExpired,
            boolean isEnabled,
            Collection<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(boolean isAccountNonExpired) {
        this.isAccountNonExpired = isAccountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean isAccountNonLocked) {
        this.isAccountNonLocked = isAccountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
        this.isCredentialsNonExpired = isCredentialsNonExpired;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    
}
