package org.isdb.DoctorBackend.dto;

import java.time.LocalDateTime;

import org.isdb.DoctorBackend.constants.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
	private Long id;
	private String email;
	private Role role;
	private String address;
	private String firstName;
	private String lastName;
	private String doctorDept;
	private String specialization;
	private String doctorDegree;
	private String doctorFee;
	private String phoneNumber;
	private String gender;
	private Integer age;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}