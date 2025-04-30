package org.isdb.DoctorBackend.dto;

import org.isdb.email.constants.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserCreateRequest(
		@NotBlank(message = "Username cannot be blank") @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters") String usersname,

		@NotBlank(message = "Email cannot be blank") @Email(message = "Email should be valid") String email,

		@NotBlank(message = "Password cannot be blank") @Size(min = 6, message = "Password must be at least 6 characters") String password,

		@NotNull(message = "Role cannot be null") Role role,

		String username, String address, Integer age, String gender,

		String phoneNumber) {
}