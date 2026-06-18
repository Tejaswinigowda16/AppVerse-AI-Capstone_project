package com.appverse;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
 
import java.util.Optional;
 
import com.appverse.dto.DeveloperDTO;
import com.appverse.entity.Developer;
import com.appverse.repository.DeveloperRepository;
import com.appverse.service.impl.DeveloperServiceImpl;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
 
@ExtendWith(MockitoExtension.class)
public class DeveloperServiceTest {
 
    @Mock
    private DeveloperRepository developerRepository;
 
    @InjectMocks
    private DeveloperServiceImpl developerService;
 
    @Test
    void testGetDeveloperById() {
 
        Developer developer = new Developer();
        developer.setDeveloperId(1L);
        developer.setDeveloperName("Teju");
 
        when(developerRepository.findById(1L))
                .thenReturn(Optional.of(developer));
 
        DeveloperDTO result = developerService.getDeveloperById(1L);
 
        assertEquals("Teju", result.getDeveloperName());
    }
}
 