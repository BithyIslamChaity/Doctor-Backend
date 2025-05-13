package org.isdb.DoctorBackend.repository;

import org.isdb.DoctorBackend.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
	// Additional custom queries can go here if needed
}
