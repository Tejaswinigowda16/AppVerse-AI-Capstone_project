package com.appverse.service.impl;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.appverse.dto.ReviewDTO;
import com.appverse.entity.Review;
import com.appverse.repository.ReviewRepository;
import com.appverse.service.ReviewService;
 
@Service
public class ReviewServiceImpl implements ReviewService {
 
    @Autowired
    private ReviewRepository reviewRepository;
 
    @Override
    public ReviewDTO addReview(ReviewDTO reviewDTO) {
 
    	Review review = new Review();
    	 
    	review.setComment(reviewDTO.getComment());
    	review.setRating(reviewDTO.getRating());
    	review.setReviewDate(reviewDTO.getReviewDate());
    	review.setUserId(reviewDTO.getUserId());
    	review.setAppId(reviewDTO.getAppId());
    	 
    	Review savedReview = reviewRepository.save(review);
    	 
    	ReviewDTO savedReviewDTO = new ReviewDTO();
    	 
    	BeanUtils.copyProperties(savedReview, savedReviewDTO);
    	 
    	return savedReviewDTO;
    	 
    }
 
    @Override
    public ReviewDTO getReviewById(Long reviewId) {
     
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found"));
     
        ReviewDTO reviewDTO = new ReviewDTO();
     
        BeanUtils.copyProperties(review, reviewDTO);
     
        return reviewDTO;
    }
 
    @Override
    public List<ReviewDTO> getAllReviews() {
     
        List<Review> reviews = reviewRepository.findAll();
     
        List<ReviewDTO> reviewDTOList = new ArrayList<>();
     
        for (Review review : reviews) {
     
            ReviewDTO reviewDTO = new ReviewDTO();
     
            reviewDTO.setReviewId(review.getReviewId());
            reviewDTO.setComment(review.getComment());
            reviewDTO.setRating(review.getRating());
            reviewDTO.setReviewDate(review.getReviewDate());
            reviewDTO.setUserId(review.getUserId());
            reviewDTO.setAppId(review.getAppId());
     
            reviewDTOList.add(reviewDTO);
        }
     
        return reviewDTOList;
    }
     
 
    @Override
    public ReviewDTO updateReview(Long reviewId,
                                  ReviewDTO reviewDTO) {
     
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found"));
     
        review.setComment(reviewDTO.getComment());
        review.setRating(reviewDTO.getRating());
        review.setReviewDate(reviewDTO.getReviewDate());
        review.setUserId(reviewDTO.getUserId());
        review.setAppId(reviewDTO.getAppId());
     
        Review updatedReview = reviewRepository.save(review);
     
        ReviewDTO updatedDTO = new ReviewDTO();
     
        BeanUtils.copyProperties(updatedReview, updatedDTO);
     
        return updatedDTO;
    }
 
    @Override
    public void deleteReview(Long reviewId) {
     
        reviewRepository.deleteById(reviewId);
    }
}
 