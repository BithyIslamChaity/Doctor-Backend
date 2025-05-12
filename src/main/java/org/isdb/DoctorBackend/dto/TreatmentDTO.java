package org.isdb.DoctorBackend.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

import lombok.Data;

@Data
public class TreatmentDTO {
	private Integer id;
	private Integer patientProfileId;
	private String treatmentName;
	private LocalDate startDate;
	private LocalDate endDate;
	private String treatmentNotes;
	private Timestamp createdAt;
	private Timestamp updatedAt;
}
