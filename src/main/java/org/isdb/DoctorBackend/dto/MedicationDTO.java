package org.isdb.DoctorBackend.dto;

import lombok.Data;

@Data
public class MedicationDTO {
	private Integer id;
	private Integer patientProfileId;
	private String medicationName;
	private String dosage;
	private String startDate; // ISO format
	private String endDate; // ISO format
}