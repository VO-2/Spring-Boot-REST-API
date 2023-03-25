package com.example.ecommerce_app.user;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import com.example.ecommerce_app.product.Product;
import com.example.ecommerce_app.purchase.Purchase;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity()
@Table(
    name = "application_user",
    uniqueConstraints = {
        @UniqueConstraint(name = "UK_email", columnNames = "email"),
    }
)
public class ApplicationUser {

    @Id
    @GeneratedValue //(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long user_id;

    @Email
    @Column(
        name = "email",
        columnDefinition = "VARCHAR(50)",
        nullable = false,
        unique = true
    )
    private String email;

    @Column(
        name = "password",
        columnDefinition = "BINARY(60)",
        nullable = false
    )
    private String password;


    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Product> products;

    @OneToMany(mappedBy = "purchaser", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Purchase> purchases;

    public ApplicationUser() {}

    public ApplicationUser(
            String password,
            String email,
            Set<Product> products,
            Set<Purchase> purchases) {
        this.password = password;
        this.email = email;
        this.products = products;
        this.purchases = purchases;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ApplicationUser other = (ApplicationUser) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }

}
