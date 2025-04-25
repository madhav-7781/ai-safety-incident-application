package com.Sparklehood.ai_safety_incident.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class IncidentDto {
    private Long id;
    private String title;
    private String description;
    private String severity;
    private LocalDateTime reportedAt;
}
