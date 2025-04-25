package com.Sparklehood.ai_safety_incident.config;

import com.Sparklehood.ai_safety_incident.model.Incident;
import com.Sparklehood.ai_safety_incident.repository.IncidentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(IncidentRepository incidentRepository) {
        return args -> {
            Incident incident1 = new Incident();
            incident1.setTitle("Bias Model Detections");
            incident1.setDescription("In this AI model shows us how AI articles are different from demographic articles");
            incident1.setSeverity("High");
            incidentRepository.save(incident1);

            Incident incident2 = new Incident();
            incident2.setTitle("leakage data");
            incident2.setDescription("training data which is sensitive is been leaked.");
            incident2.setSeverity("Medium");
            incidentRepository.save(incident2);
        };
    }
}
