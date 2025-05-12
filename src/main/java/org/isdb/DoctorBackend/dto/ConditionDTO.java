package org.isdb.DoctorBackend.dto;

import lombok.Data;

@Data
public class ConditionDTO {
    private Integer id;
    private Integer patientProfileId;
    private String conditionName;
    private String status;
    private String diagnosisDate; // ISO string
}
