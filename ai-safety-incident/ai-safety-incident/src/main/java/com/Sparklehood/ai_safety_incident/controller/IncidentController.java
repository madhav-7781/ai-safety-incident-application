package com.Sparklehood.ai_safety_incident.controller;
import com.Sparklehood.ai_safety_incident.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import com.Sparklehood.ai_safety_incident.dto.IncidentDto;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/incidents")
public class IncidentController {
    @Autowired
    private IncidentService incidentservice;
    @GetMapping
    public ResponseEntity<List<IncidentDto>> getallincidents() {
        List<IncidentDto> incidents = incidentservice.getAllIncidents();
        return ResponseEntity.ok(incidents);
    }
    @GetMapping("/{id}")
    public ResponseEntity<IncidentDto> getincidentbyid(@PathVariable Long id) {
        IncidentDto incident = incidentservice.getIncidentById(id);
        if(incident != null) {
            return ResponseEntity.ok(incident);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<IncidentDto> createincidents(@Validated @RequestBody IncidentDto incidentDto) {
        if(!isvalidseverity(incidentDto.getSeverity())) {
            return ResponseEntity.badRequest().build();
        }
        IncidentDto createdIncident = incidentservice.createIncident(incidentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdIncident);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteincidents(@PathVariable Long id) {
        if(incidentservice.deleteIncident(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    private boolean isvalidseverity(String severity) {
        return severity != null && (severity.equals("Low") || severity.equals("Medium") || severity.equals("High"));
    }

}
