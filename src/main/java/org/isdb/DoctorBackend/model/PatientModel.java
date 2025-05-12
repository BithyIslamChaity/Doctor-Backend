package org.isdb.DoctorBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patients")
public class PatientModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String email;
	private Integer age;
	private String gender;
	private String phoneNumber;

	private String address;

	private String medicalHistory;

//	@Column(name = "created_at")
//	private LocalDateTime createdAt;

//	@Column(name = "updated_at")
//	private LocalDateTime updatedAt;

	// Parameterized constructor
	public PatientModel(String name, String email, Integer age, String gender, String phoneNumber, String address,
			String medicalHistory) {

		this.name = name;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.medicalHistory = medicalHistory;
	}

}
