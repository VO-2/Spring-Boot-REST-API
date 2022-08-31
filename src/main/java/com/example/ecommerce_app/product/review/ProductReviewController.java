package com.example.ecommerce_app.product.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product-review")
public class ProductReviewController {
    
    @Autowired
    private ProductReviewService productReviewService;

    @GetMapping("{productReviewId}")
    public ProductReview getProductReview(@PathVariable Long productReviewId) {
        return productReviewService.getProductReview(productReviewId);
    }

    @GetMapping
    public List<ProductReview> getAllProductReviews() {
        return productReviewService.getAllProductReviews();
    }

    @PostMapping
    public ProductReview createProductReview(@RequestBody ProductReview productReview) {
        return productReviewService.saveProductReview(productReview);
    }

    @PutMapping
    public ProductReview updateProductReview(@RequestBody ProductReview productReview) {
        return productReviewService.saveProductReview(productReview);
    }

    @DeleteMapping("{productReviewId}")
    public void deleteProductReview(@PathVariable Long productReviewId) {
        productReviewService.deleteProductReview(productReviewId);
    }
    
}
