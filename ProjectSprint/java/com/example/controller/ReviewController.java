package com.example.controller;

import com.example.model.Review;
import com.example.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController 
{
	@Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/showReviews")
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        return reviewRepository.findById(id)
                .map(review -> new ResponseEntity<>(review, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/postReview")
    public ResponseEntity<String> addReview(@RequestBody Review review) {
        reviewRepository.save(review);
        return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateReview(@PathVariable Long id, @RequestBody Review updatedReview) {
        return reviewRepository.findById(id)
                .map(existingReview -> {
                    existingReview.setReviewText(updatedReview.getReviewText());
                    existingReview.setRating(updatedReview.getRating());
                    reviewRepository.save(existingReview);
                    return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id) {
        return reviewRepository.findById(id)
                .map(review -> {
                    reviewRepository.deleteById(id);
                    return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND));
    }
}
