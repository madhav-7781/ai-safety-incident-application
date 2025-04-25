package com.Sparklehood.ai_safety_incident.service;

import com.Sparklehood.ai_safety_incident.dto.IncidentDto;
import com.Sparklehood.ai_safety_incident.model.Incident;
import com.Sparklehood.ai_safety_incident.repository.IncidentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    public List<IncidentDto> getAllIncidents() {
        return incidentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public IncidentDto getIncidentById(Long id) {
        return incidentRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Transactional
    public IncidentDto createIncident(IncidentDto incidentDto) {
        Incident incident = new Incident();
        incident.setTitle(incidentDto.getTitle());
        incident.setDescription(incidentDto.getDescription());
        incident.setSeverity(incidentDto.getSeverity());

        Incident savedIncident = incidentRepository.save(incident);
        return convertToDTO(savedIncident);
    }

    @Transactional
    public boolean deleteIncident(Long id) {
        if(incidentRepository.existsById(id)) {
            incidentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private IncidentDto convertToDTO(Incident incident) {
        IncidentDto dto = new IncidentDto();
        dto.setId(incident.getId());
        dto.setTitle(incident.getTitle());
        dto.setDescription(incident.getDescription());
        dto.setSeverity(incident.getSeverity());
        dto.setReportedAt(incident.getReportedAt());
        return dto;
    }
}
