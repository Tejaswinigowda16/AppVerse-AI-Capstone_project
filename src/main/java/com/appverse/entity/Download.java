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
public class Download {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long downloadId;
 
    private Long userId;
 
    private Long appId;
 
    private LocalDate downloadDate;
    
    public Long getDownloadId() {
        return downloadId;
    }
     
    public void setDownloadId(Long downloadId) {
        this.downloadId = downloadId;
    }
     
    public Long getUserId() {
        return userId;
    }
     
    public void setUserId(Long userId) {
        this.userId = userId;
    }
     
    public Long getAppId() {
        return appId;
    }
     
    public void setAppId(Long appId) {
        this.appId = appId;
    }
     
    public LocalDate getDownloadDate() {
        return downloadDate;
    }
     
    public void setDownloadDate(LocalDate downloadDate) {
        this.downloadDate = downloadDate;
    }
     
}
 