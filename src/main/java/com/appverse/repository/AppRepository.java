package com.appverse.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.appverse.entity.App;
 
@Repository
public interface AppRepository extends JpaRepository<App, Long> {
 
}
 