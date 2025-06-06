package org.isdb.DoctorBackend.dto;

import org.isdb.DoctorBackend.annotation.ValidRole;
import org.isdb.DoctorBackend.constants.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
		@NotBlank(message = "Email cannot be blank") @Email(message = "Email should be valid") String email,

		@NotBlank(message = "Password cannot be blank") @Size(min = 5, message = "Password must be at least 5 characters") String password,

		@ValidRole(message = "Role must be valid") @Enumerated(value = EnumType.STRING) Role role,

		String firstName, String lastName, Integer age, String gender, String phoneNumber) {
}