package org.isdb.DoctorBackend.repository;

import org.isdb.DoctorBackend.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	Payment findByAppointment_id(Long appointmentID);
}
