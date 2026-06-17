package com.appverse.dto;
 
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationDTO {
 
    private Long appId;
    private String appName;
    private String description;
    private String version;
}
 