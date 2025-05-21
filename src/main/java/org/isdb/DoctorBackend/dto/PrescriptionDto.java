package org.isdb.DoctorBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDTO {

	private Long doctorId;

	private Long patientId;

	private String medicineName;

	private String medicineDosage;

	private String duration;
}
