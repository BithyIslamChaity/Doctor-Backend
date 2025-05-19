package org.isdb.DoctorBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_PRESCRIPTION")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id",  nullable = false,  referencedColumnName = "id")
    private User doctorId;

    @ManyToOne
    @JoinColumn(name = "patient_id",  nullable = false,  referencedColumnName = "id")
    private User patientId;

    private String medicineName;

    private String medicineDosage;

    private String duration;

}
