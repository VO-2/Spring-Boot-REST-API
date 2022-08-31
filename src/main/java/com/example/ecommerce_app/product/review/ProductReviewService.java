package com.example.ecommerce_app.product.review;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce_app.util.Repositories;

@Service
@Transactional
public class ProductReviewService {

    @Autowired
    private ProductReviewRepository productReviewRepository;

    public ProductReview getProductReview(Long productReviewId) {
        return Repositories.getEntityById(productReviewRepository, productReviewId);
    }

    public List<ProductReview> getAllProductReviews() {
        return productReviewRepository.findAll();
    }

    public ProductReview saveProductReview(ProductReview productReview) {
        return productReviewRepository.save(productReview);
    }

    public void deleteProductReview(Long productReveiwId) {
        productReviewRepository.deleteById(productReveiwId);
    }

    public void deleteProductReview(ProductReview productReview) {
        productReviewRepository.delete(productReview);
    }
}
