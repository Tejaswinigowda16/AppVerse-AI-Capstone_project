package com.appverse.entity;
 
import java.time.LocalDate;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
 
    private String comment;
 
    private int rating;
 
    private LocalDate reviewDate;
 
    private Long userId;
 
    private Long appId;
    
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
    
    public Long getReviewId() {
        return reviewId;
    }
     
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
     
    public Long getAppId() {
        return appId;
    }
     
     
}
 