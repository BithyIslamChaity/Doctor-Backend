package org.isdb.DoctorBackend.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Data
public class Treatment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String treatmentName;
	private LocalDate startDate;
	private LocalDate endDate;

	private String treatmentNotes;

}
