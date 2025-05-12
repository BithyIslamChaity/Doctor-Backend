package org.isdb.DoctorBackend.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DoctorDTO {

	private Integer id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String specialty;
	private Integer yearsOfExperience;

	private Timestamp createdAt;
	private Timestamp updatedAt;
}
