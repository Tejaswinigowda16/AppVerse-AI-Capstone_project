package com.appverse.repository;
 
import com.appverse.entity.App;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface RecommendationRepository extends JpaRepository<App, Long> {
 
}