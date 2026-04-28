package org.example.hnk24cntt1_lathephong_002.config;

import lombok.RequiredArgsConstructor;
import org.example.hnk24cntt1_lathephong_002.model.Artifact;
import org.example.hnk24cntt1_lathephong_002.repository.ArtifactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
@Configuration
@RequiredArgsConstructor
public class DataInit {
    private final ArtifactRepository artifactRepository;
    @Bean
    CommandLineRunner initDaTa(){
        return args -> {
            if(artifactRepository.count()==0){
                artifactRepository.save(new Artifact(null, "Trống đồng Đông Sơn", "Thanh Hóa", LocalDate.now().minusDays(1)));
                artifactRepository.save(new Artifact(null, "Đền Bà Triệu", "Thanh Hóa", LocalDate.now().minusDays(1)));
            }
        };
    }
}
