//package org.isdb.DoctorBackend.model;
//
//import java.time.LocalDateTime;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import lombok.Data;
//
//@Entity
//@Data
//public class Condition {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//
//	@ManyToOne
//	@JoinColumn(name = "patient_profile_id", nullable = false)
//
//	@Column(nullable = false)
//	private String conditionName;
//
//	private String status;
//
//	private LocalDateTime diagnosisDate;
//
//}