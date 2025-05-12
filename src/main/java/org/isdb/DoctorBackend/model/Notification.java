package org.isdb.DoctorBackend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long userId;
	private Long appointmentId;

	private String message;
	private String type;
	private String status;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	// Getters and setters
}
