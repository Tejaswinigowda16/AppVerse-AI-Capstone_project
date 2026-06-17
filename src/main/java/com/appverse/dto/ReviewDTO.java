package com.appverse.dto;
 
import java.time.LocalDate;
 
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
 
    private Long reviewId;
 
    @NotBlank(message = "Comment is required")
    private String comment;
 
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating cannot exceed 5")
    private int rating;
 
    private LocalDate reviewDate;
 
    private Long userId;
 
    private Long appId;
    
    public String getComment() {
        return comment;
    }
     
    public int getRating() {
        return rating;
    }
     
    public LocalDate getReviewDate() {
        return reviewDate;
    }
     
    public Long getUserId() {
        return userId;
    }
    
    public Long getReviewId() {
        return reviewId;
    }
     
    public Long getAppId() {
        return appId;
    }
    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }
     
    public void setComment(String comment) {
        this.comment = comment;
    }
     
    public void setRating(int rating) {
        this.rating = rating;
    }
     
    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }
     
    public void setUserId(Long userId) {
        this.userId = userId;
    }
     
    public void setAppId(Long appId) {
        this.appId = appId;
    }
     
}
 