package org.isdb.DoctorBackend.repository;

import org.isdb.DoctorBackend.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
