package com.example.ecommerce_app.product;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce_app.user.ApplicationUserRepository;
import com.example.ecommerce_app.util.Repositories;

@Service
@Transactional
public class ProductService {

    private ProductRepository productRepository;
    private ApplicationUserRepository applicationUserRepository;

    public ProductService(ProductRepository productRepository, ApplicationUserRepository applicationUserRepository) {
        this.productRepository = productRepository;
        this.applicationUserRepository = applicationUserRepository;
    }

    public Product getProduct(Long productId) {
        return Repositories.getEntityById(productRepository, productId);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product, Long userId) {
        if (userId != null) {
            product.setOwner(Repositories.getEntityById(applicationUserRepository, userId));
        }
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        if (productRepository.existsById(product.getProduct_id())) {
            return productRepository.save(product);
        }
        else {
            throw new IllegalStateException("Product with productId '" + product.getProduct_id() + "' does not exist");
        }
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public List<Product> searchProducts(String productName) {
        return productRepository.findByNameIgnoreCaseContains(productName);
    }

}
