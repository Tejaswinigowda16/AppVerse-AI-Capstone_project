package com.appverse.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.appverse.entity.Download;
 
@Repository
public interface DownloadRepository extends JpaRepository<Download, Long> {
 
}
 