//package org.isdb.DoctorBackend.model;
//
//import java.security.Timestamp;
//import java.time.LocalDate;
//
//import org.springframework.data.annotation.Id;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.Lob;
//import jakarta.persistence.ManyToOne;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity
//@Data
//public class PatientProfile {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//
//	@ManyToOne
//	@JoinColumn(name = "patient_id", nullable = false)
//	private User patient;
//
//	private String fullName;
//	private LocalDate dateOfBirth;
//	private String gender;
//	private String phoneNumber;
//
//	
//	private String address;
//
//	private Timestamp createdAt;
//	private Timestamp updatedAt;
//}
