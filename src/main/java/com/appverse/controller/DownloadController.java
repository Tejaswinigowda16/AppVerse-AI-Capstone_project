package com.appverse.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import com.appverse.dto.DownloadDTO;
import com.appverse.service.DownloadService;
 
@RestController
@RequestMapping("/api/downloads")
public class DownloadController {
 
    @Autowired
    private DownloadService downloadService;
 
    @PostMapping
    public String addDownload(@RequestBody DownloadDTO downloadDTO) {
 
        downloadService.addDownload(downloadDTO);
 
        return "Download Added Successfully";
    }
 
    @GetMapping("/{id}")
    public DownloadDTO getDownloadById(@PathVariable Long id) {
 
        return downloadService.getDownloadById(id);
    }
 
    @GetMapping
    public List<DownloadDTO> getAllDownloads() {
 
        return downloadService.getAllDownloads();
    }
 
    @PutMapping("/{id}")
    public DownloadDTO updateDownload(@PathVariable Long id,
                                      @RequestBody DownloadDTO downloadDTO) {
 
        return downloadService.updateDownload(id, downloadDTO);
    }
 
    @DeleteMapping("/{id}")
    public String deleteDownload(@PathVariable Long id) {
 
        downloadService.deleteDownload(id);
 
        return "Download Deleted Successfully";
    }
}
 