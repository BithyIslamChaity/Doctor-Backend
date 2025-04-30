package org.isdb.DoctorBackend.dto;

import org.springframework.context.annotation.Role;

import jakarta.validation.constraints.Email;

public record UserUpdateRequest(@Email(message = "Email should be valid") String email,

		Role role, String username, String address, Integer age, String gender, String phoneNumber) {
}
