package org.isdb.DoctorBackend.repository;

import org.isdb.DoctorBackend.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
