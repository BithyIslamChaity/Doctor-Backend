package org.isdb.DoctorBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String strength; // e.g., "500mg"
	private String generic; // e.g., "Paracetamol"
	private String type; // e.g., "Tablet", "Syrup"
	private String company; // Manufacturer
	private Integer sNumber; // Serial or stock number
}
