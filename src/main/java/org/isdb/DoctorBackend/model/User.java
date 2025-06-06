package org.isdb.DoctorBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.isdb.DoctorBackend.constants.Role;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private String gender;

    private Integer age;

    private String phoneNumber;

    private String firstName;

    private String lastName;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // ================== Doctor-specific fields ==================
    private String specialization; // e.g., Cardiology, Dermatology
    private String licenseNumber; // Medical license number
    private Integer yearsOfExperience;
    private String clinicAddress;

    // ================== Patient-specific fields ==================
    private String emergencyContact;
    private String medicalHistory; // Optional summary or ID pointing to a medical history record
    private String insuranceProvider;

    // ================== Admin-specific fields ==================
    private Boolean canManageUsers; // Whether this admin can create/update/delete users
    private Boolean canAccessReports;

    public User(String email, String password, Role role, Integer age, String gender, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
