package com.Sparklehood.ai_safety_incident.model;

import java.time.LocalDateTime;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name="incident_table")
public class Incident {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable=false, columnDefinition="TEXT")
    private String description;

    @Column(nullable = false)
    private String severity;

    @Column(name="reportedat", nullable = false)
    private LocalDateTime reportedAt;

    @PrePersist
    protected void onCreate() {
        reportedAt = LocalDateTime.now();
    }
}
