package com.appverse.dto;
 
import java.time.LocalDate;
 
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DownloadDTO {
 
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
 