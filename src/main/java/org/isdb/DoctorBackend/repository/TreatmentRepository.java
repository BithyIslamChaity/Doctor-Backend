package org.isdb.DoctorBackend.repository;

import org.isdb.DoctorBackend.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment, Integer> {
}
