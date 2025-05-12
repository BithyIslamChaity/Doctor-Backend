package org.isdb.DoctorBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PatientDTO {

	private String name;
	private String email;
	private Integer age;
	private String gender;
	private String phoneNumber;
	private String address;
	private String medicalHistory;

}
