package org.isdb.DoctorBackend.repository;

import org.isdb.DoctorBackend.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
}
