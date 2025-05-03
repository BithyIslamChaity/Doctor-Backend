package org.isdb.DoctorBackend.dto;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
	private Long id;
	private String username;
	private String email;
	private Role role;
	private String address;
	private String phoneNumber;
	private String gender;
	private Integer age;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}