package com.appverse.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import com.appverse.dto.ReviewDTO;
import com.appverse.service.ReviewService;
 
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
 
    @Autowired
    private ReviewService reviewService;
 
    @PostMapping
    public String addReview(@RequestBody ReviewDTO reviewDTO) {
 
        reviewService.addReview(reviewDTO);
 
        return "Review Added Successfully";
    }
 
    @GetMapping("/{id}")
    public ReviewDTO getReviewById(@PathVariable Long id) {
 
        return reviewService.getReviewById(id);
    }
 
    @GetMapping
    public List<ReviewDTO> getAllReviews() {
 
        return reviewService.getAllReviews();
    }
 
    @PutMapping("/{id}")
    public ReviewDTO updateReview(@PathVariable Long id,
                                  @RequestBody ReviewDTO reviewDTO) {
 
        return reviewService.updateReview(id, reviewDTO);
    }
 
    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Long id) {
 
        reviewService.deleteReview(id);
 
        return "Review Deleted Successfully";
    }
}
 