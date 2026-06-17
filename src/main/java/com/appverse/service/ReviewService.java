package com.appverse.service;
 
import java.util.List;
 
import com.appverse.dto.ReviewDTO;
 
public interface ReviewService {
 
    ReviewDTO addReview(ReviewDTO reviewDTO);
 
    ReviewDTO getReviewById(Long reviewId);
 
    List<ReviewDTO> getAllReviews();
 
    ReviewDTO updateReview(Long reviewId, ReviewDTO reviewDTO);
 
    void deleteReview(Long reviewId);
}
 