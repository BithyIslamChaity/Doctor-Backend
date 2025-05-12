package org.isdb.DoctorBackend.repository;

import org.isdb.DoctorBackend.model.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorModel, Integer> {
}
