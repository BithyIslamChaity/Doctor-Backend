package org.isdb.DoctorBackend.dto;

import jakarta.validation.constraints.Email;
import org.isdb.DoctorBackend.constants.Role;

public record UserUpdateRequest(
        @Email(message = "Email should be valid")
        String email,

        Role role,
        String address,
        Integer age,
        String gender,
        String phoneNumber
) {
}
