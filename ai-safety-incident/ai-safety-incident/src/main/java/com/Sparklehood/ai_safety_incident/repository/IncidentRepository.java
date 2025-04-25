package com.Sparklehood.ai_safety_incident.repository;

import com.Sparklehood.ai_safety_incident.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {
}
