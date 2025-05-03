package org.isdb.DoctorBackend.dto;

import lombok.Getter;
import lombok.Setter;
import org.isdb.DoctorBackend.constants.Role;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String email;
    private Role role;
    private String address;
    private String phoneNumber;
    private String gender;
    private Integer age;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}